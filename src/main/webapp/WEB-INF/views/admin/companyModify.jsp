<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/admin/companyModify.css">

<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
</head>
<body>
				<%@include file="../includes/admin/header.jsp" %>
                <div class="admin_content_wrap">
                    <div class="admin_content_subject"><span>회사 상세</span></div>
                    <div class="admin_content_main">
                    	<form id="modifyForm" action="/admin/companyModify" method="post">
	                   		<div class="form_section">
	                   			<div class="form_section_title">
	                   				<label>회사 번호</label>
	                   			</div>
	                   			<div class="form_section_content">
	                   				<input class="input_block" name="companyId" readonly="readonly" value="<c:out value='${companyInfo.companyId }'></c:out>">
	                   			</div>
	                   		</div>                    
	                   		<div class="form_section">
	                   			<div class="form_section_title">
	                   				<label>회사 이름</label>
	                   			</div>
	                   			<div class="form_section_content">
	                   				<input name="companyName" value="<c:out value='${companyInfo.companyName }'></c:out>" >
	                   				<span id="warn_companyName">회사 이름을 입력 해주세요.</span>
	                   			</div>
	                   		</div>
	                   		<div class="form_section">
	                   			<div class="form_section_title">
	                   				<label>소속 국가</label>
	                   			</div>
	                   			<div class="form_section_content">
	                   				<select name="nationId" >
	                   					<option value="none" disabled="disabled">=== 선택 ===</option>
	                   					<option value="01" <c:out value=" ${companyInfo.nationId eq '01' ?'selected':''}"/>>국내</option>
	                   					<option value="02" <c:out value=" ${companyInfo.nationId eq '02' ?'selected':''}"/>>국외</option>
	                   				</select>
	                   			</div>
	                   		</div>
	                   		<div class="form_section">
	                   			<div class="form_section_title">
	                   				<label>회사소개</label>
	                   			</div>
	                   			<div class="form_section_content">
	                   				<textarea name="companyIntro" ><c:out value='${companyInfo.companyIntro }'/></textarea>
	                   				<span id="warn_companyIntro">회사 소개를 입력 해주세요.</span>
	                   			</div>
	                   		</div>
	                   		<div class="form_section">
	                   			<div class="form_section_title">
	                   				<label>등록 날짜</label>
	                   			</div>
	                   			<div class="form_section_content">
	                   				<input class="input_block" type="text" readonly="readonly" value="<fmt:formatDate value="${companyInfo.regDate}" pattern="yyyy-MM-dd"/>">
	                   			</div>
	                   		</div>
	                   		<div class="form_section">
	                   			<div class="form_section_title">
	                   				<label>수정 날짜</label>
	                   			</div>
	                   			<div class="form_section_content">
	                   				<input class="input_block" type="text" readonly="readonly" value="<fmt:formatDate value="${companyInfo.updateDate}" pattern="yyyy-MM-dd"/>">
	                   			</div>
	                   		</div>
	                 		<div class="btn_section">
	                   			<button id="cancelBtn" class="btn">취소</button>
		                    	<button id="modifyBtn" class="btn modify_btn">수 정</button>
		                    	<button id="deleteBtn" class="btn delete_btn">삭 제</button>
		                    </div> 
	                    </form>
                    </div>                    
                </div>
                
                <form id="moveForm" method="get">
                	<input type="hidden" name="companyId" value='<c:out value="${companyInfo.companyId }"/>'>
                	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum }"/>'>
                	<input type="hidden" name="amount" value='<c:out value="${cri.amount }"/>' >
                	<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>'>
                </form>
				<%@include file="../includes/admin/footer.jsp" %>

<script>

	let moveForm = $("#moveForm");
	let modifyForm = $("#modifyForm");
	



	/* 회사 상세 페이지 이동 버튼 */
	$("#cancelBtn").on("click", function(e){
		
		e.preventDefault();
				
		moveForm.attr("action", "/admin/companyDetail")
		moveForm.submit();
		
	});
	
	/* 삭제 버튼 */
	$("#deleteBtn").on("click", function(e){
		e.preventDefault();
		moveForm.find("input").remove();
		moveForm.append('<input type="hidden" name="companyId" value="${companyInfo.companyId}">');
		moveForm.attr("action", "/admin/companyDelete");
		moveForm.attr("method", "post");
		moveForm.submit();
	});	
	
	/* 회사 수정 버튼 작동 및 유효성 검사 */
	$("#modifyBtn").on("click", function(e){

		let companyName = $(".form_section_content input[name='companyName']").val();
		let companyIntro = $(".form_section_content textarea").val();		

		let	nameCk = false;
		let introCk = false;		
		
		e.preventDefault();
		
		if(!companyName){
			$("#warn_companyName").css("display", "block");
		} else {
			$("#warn_companyName").css("display", "none");
			nameCk = true;
		}
		if(!companyIntro){
			$("#warn_companyIntro").css("display", "block");
		} else {
			$("#warn_companyIntro").css("display", "none");
			introCk = true;
		}

		
		if(nameCk && introCk ){
			modifyForm.submit();	
		} else {
			return false;
		}
		
		
	});
	
	
	

</script>

</body>
</html>