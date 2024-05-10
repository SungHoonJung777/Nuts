package com.vam.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.vam.mapper.AttachMapper;

import com.vam.mapper.CartMapper;
import com.vam.mapper.MemberMapper;
import com.vam.mapper.OrderMapper;
import com.vam.mapper.ProductMapper;
import com.vam.model.AttachImageVO;
import com.vam.model.CartDTO;
import com.vam.model.MemberVO;
import com.vam.model.OrderCancelDTO;
import com.vam.model.OrderDTO;
import com.vam.model.OrderItemDTO;
import com.vam.model.OrderPageItemDTO;
import com.vam.model.ProductVO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private AttachMapper attachMapper;

	@Autowired
	private MemberMapper memberMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders) {
		List<OrderPageItemDTO> result = new ArrayList<>();

		for (OrderPageItemDTO ord : orders) {
			OrderPageItemDTO goodsInfo = orderMapper.getGoodsInfo(ord.getpillId());
			goodsInfo.setpillCount(ord.getpillCount());
			goodsInfo.initSaleTotal();
			List<AttachImageVO> imageList = attachMapper.getAttachList(goodsInfo.getpillId());
			goodsInfo.setImageList(imageList);
			result.add(goodsInfo);
		}

		return result;
	}

	@Override
	@Transactional
	public void order(OrderDTO ord) {
		// ����� ������ ��������
		MemberVO member = memberMapper.getMemberInfo(ord.getMemberId());
		List<OrderItemDTO> ords = new ArrayList<>();

		for (OrderItemDTO oit : ord.getOrders()) {
			OrderItemDTO orderItem = orderMapper.getOrderInfo(oit.getpillId());
			orderItem.setpillCount(oit.getpillCount());
			orderItem.initSaleTotal();
			ords.add(orderItem);
		}

		ord.setOrders(ords);
		ord.getOrderPriceInfo();

		// DB �ֹ�, �ֹ���ǰ(,�������) �ֱ�
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
		String orderId = member.getMemberId() + format.format(date);
		ord.setOrderId(orderId);

		orderMapper.enrollOrder(ord); // vam_order ���

		for (OrderItemDTO oit : ord.getOrders()) {
			oit.setOrderId(orderId);
			orderMapper.enrollOrderItem(oit);
		}

		// ��� ����Ʈ ���� ����
		int calMoney = member.getMoney();
		calMoney -= ord.getOrderFinalSalePrice();
		member.setMoney(calMoney);

		int calPoint = member.getPoint();
		calPoint = calPoint - ord.getUsePoint() + ord.getOrderSavePoint();
		member.setPoint(calPoint);

		orderMapper.deductMoney(member);

		// ��� ���� ����
		for (OrderItemDTO oit : ord.getOrders()) {
			ProductVO pill = productMapper.getGoodsInfo(oit.getpillId());
			pill.setPillStock(pill.getPillStock() - oit.getpillCount());
			orderMapper.deductStock(pill);
		}

		// ��ٱ��� ����
		for (OrderItemDTO oit : ord.getOrders()) {
			CartDTO dto = new CartDTO();
			dto.setMemberId(ord.getMemberId());
			dto.setpillId(oit.getpillId());
			cartMapper.deleteOrderCart(dto);
		}
	}

	/* �ֹ���� */
	@Override
	@Transactional
	public void orderCancle(OrderCancelDTO dto) {

		/* �ֹ�, �ֹ���ǰ ��ü */
		/* ȸ�� */
		MemberVO member = memberMapper.getMemberInfo(dto.getMemberId());
		/* �ֹ���ǰ */
		List<OrderItemDTO> ords = orderMapper.getOrderItemInfo(dto.getOrderId());
		for (OrderItemDTO ord : ords) {
			ord.initSaleTotal();
		}
		/* �ֹ� */
		OrderDTO orw = orderMapper.getOrder(dto.getOrderId());
		orw.setOrders(ords);

		orw.getOrderPriceInfo();

		/* �ֹ���ǰ ��� DB */
		orderMapper.orderCancle(dto.getOrderId());

		/* ��, ����Ʈ, ��� ��ȯ */
		/* �� */
		int calMoney = member.getMoney();
		calMoney += orw.getOrderFinalSalePrice();
		member.setMoney(calMoney);

		/* ����Ʈ */
		int calPoint = member.getPoint();
		calPoint = calPoint + orw.getUsePoint() - orw.getOrderSavePoint();
		member.setPoint(calPoint);

		/* DB���� */
		orderMapper.deductMoney(member);

		/* ��� */
		for (OrderItemDTO ord : orw.getOrders()) {
			ProductVO pill = productMapper.getGoodsInfo(ord.getpillId());
			pill.setPillStock(pill.getPillStock() + ord.getpillCount());
			orderMapper.deductStock(pill);
		}

	}

}