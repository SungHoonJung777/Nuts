<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, inital-scale=1.0">

<!-- swiper css -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />

<!-- box icons -->
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<title>넛츠</title>

<link rel="shortcut icon" sizes="76x76" type="image/x-icon"
	href="https://a0.muscache.com/airbnb/static/logotype_favicon-21cc8e6c6a2cca43f061d2dcabdf6e58.ico">

<link rel="stylesheet" href="resources/css/shopping.css">
<meta http-equiv="X-UA_Compatible" content="IE=edge">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<script type="text/javascript" src="member/member.js"></script>
<script
  src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>  
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
#item {
	width: 200px;
	margin: 0 13px;
}

#item img {
	width: 100%;
	height: auto;
}

#itemdetail  img {
	width: 190px;
	height: 200px;
	margin-right: 20px;
}

.input-box button {
	background: #359381;
	border: none;
	outline: none;
	border-radius: 6px;
	cursor: pointer;
	width: 25%;
	height: 30px;
	text-align: center;
	margin-top: 12px;
}

.btn {
	width: 100%;
	height: 45px;
	background: #359381;
	border: none;
	outline: none;
	border-radius: 6px;
	cursor: pointer;
	font-size: 1em;
	color: #fff;
	font-weight: 500;
}

#item a, #item a h3, #item a p {
	color: #fff;
	text-decoration: none;
}

#item {
	border: 2px solid #ccc;
	border-radius: 10px;
	padding: 10px;
	margin-bottom: 10px;
	transition: transform 0.3s ease-in-out;
	box-sizing: border-box;
	line-height: 1.2;
	font-size: 14px;
}

.container {
	position: relative;
	max-width: 1400px;
	width: 100%;
	padding: 40px;
}

.container .box {
	padding: 50px 30px;
	overflow: hidden;
}

.image img {
	width: 100px;
	height: 100px;
	object-fit: cover;
	border-radius: 50%;
	opacity: .8;
	border: 3px solid #fff;
}

.card {
	width: 250px;
	height: auto;
	background: transparent;
	box-shadow: inset 20px 20px 20px rgba(0, 0, 0, .05), 5px 25px 20px
		rgba(0, 0, 0, .05), 5px 20px 30px rgba(0, 0, 0, .05), inset -20px
		-20px 25px rgba(255, 255, 255, .9);
	border-radius: 61% 39% 52% 48%/44% 59% 41% 56%;
	transition: .5s ease-in-out;
	color: #fff;
}

.card:hover {
	border-radius: 50%;
}

.card::before {
	content: '';
	position: absolute;
	top: 35px;
	left: 70px;
	width: 35px;
	height: 35px;
	background: #fff;
	border-radius: 50%;
	opacity: .9;
}

.card::after {
	content: '';
	position: absolute;
	top: 70px;
	left: 90px;
	width: 15px;
	height: 15px;
	background: #fff;
	border-radius: 50%;
	opacity: .9;
}

.card .card-content {
	position: relative;
	display: flex;
	align-items: center;
	flex-direction: column;
	padding: 30px;
}

.card-content .name-profession {
	display: flex;
	align-items: center;
	flex-direction: column;
	margin-top: 10px;
	color: #333;
}

.name-profession .name {
	font-size: 20px;
	font-weight: 600;
}

.name-profession .profession {
	font-size: 15px;
	font-weight: 500;
}

.card-content .rating {
	display: flex;
	align-items: center;
	margin-top: 18px;
}

.card-content .rating i {
	font-size: 22px;
	color: var(--clr);
	margin: 0 2px;
	opacity: .75;
}

.card-content button {
	position: relative;
	padding: 8px 35px;
	background: var(--clr);
	border: none;
	outline: none;
	border-radius: 40px;
	box-shadow: 0 2px 2px rgba(0, 0, 0, .25);
	cursor: pointer;
	color: #000;
	font-weight: 500;
	opacity: .75;
	margin-top: 30px;
}

.card-content button::before {
	content: '';
	position: absolute;
	top: 6px;
	left: 50%;
	transform: translateX(-50%);
	width: 55%;
	height: 5px;
	background: rgba(255, 255, 255, .5);
	border-radius: 5px;
}

.box .swiper-button-next, .box .swiper-button-prev {
	color: #666;
}

.box .swiper-button-next {
	right: 0;
}

.box .swiper-button-prev {
	left: 0;
}

.box .swiper-pagination-bullet {
	width: 12px;
	height: 12px;
	background: #666;
}

#item h3 {
	font-size: 16px;
}

#item:hover {
	transform: scale(1.05);
}

#item a:hover, #item a h3:hover, #item a p:hover {
	color: #00f;
}

footer {
  background-color: #359381;
  color: #333;
  padding: 30px;
  text-align: center;
}

.footer-container {
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  max-width: 900px;
  margin: 0 auto;
}

.footer-nav ul {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
}

.footer-nav ul li {
  margin-right: 20px;
}

.footer-nav ul li:last-child {
  margin-right: 0;
}

.footer-nav ul li a {
  color: #333;
  text-decoration: none;
  font-weight: bold;
  transition: color 0.3s ease;
}

.footer-nav ul li a:hover {
  color: #359381;
}

.footer-follow {
  display: flex;
  align-items: center;
}

.footer-follow span {
  margin-right: 10px;
}

.social-icon {
  display: inline-block;
  width: 40px;
  height: 40px;
  background-color: #f2f2f2;
  color: #fff;
  border-radius: 50%;
  text-align: center;
  line-height: 40px;
  margin-right: 10px;
  transition: background-color 0.3s ease;
}

.social-icon:hover {
  background-color: #005f6b;
}

.fa {
  font-size: 20px;
}
.pan button{
    position: absolute;
    left: 100px;
    font-weight: 700;
    margin-top: 15px;
    width: 150px;
    top: 3900px;
}
.photo{
    position: absolute;
    right: 120px;
    top: 3670px;
}
#event{
    font-size: 4em;
    width: 258px;
    color: white;
    font-family: sans-serif;
    position: absolute;
    top: 3670px;
    left:100px;
    animation: slide 0.01s ease-out;
}
</style>

</head>
<body>
	<header>
		<h2 class="logo">Nuts</h2>
		<nav class="navigation">
			
			<a href="NutsServlet?command=main">Home</a> <a href="#" id="ai-link">AI 추천 받기</a> <a
				href="https://port-0-pharmacyback-1maxx2algpyhxqx.sel3.cloudtype.app/">주변 약국 찾기</a> <a href="NutsServlet?command=board_page">공지사항</a>
			<button class="btnLogin-popup">
				<c:choose>
					<c:when test="${empty sessionScope.member}">
           				Login
            </c:when>
					<c:otherwise>
						
						<a style="color: red" href="/member/logout.do">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</button>
			<!--  
			<div class="login_success_area">
				<c:if test="${ member != null }">
                    <div class="login_success_area">
                        <span>회원 : ${member.memberName}</span>
                        <!-- <span>충전금액 : <fmt:formatNumber value="${member.money }" pattern="\#,###.##"/></span>
                         <span>포인트 : <fmt:formatNumber value="${member.point }" pattern="#,###" /></span>-->
                    <!-- </div>
                </c:if>
			</div>
			 -->
			<div>
				<c:if test="${member != null }">	<!-- 로그인 o -->		
					<c:if test="${member.adminCk == 1 }">	<!-- 관리자 계정 -->
						<li><a href="/admin/main">관리자 페이지</a></li>
					</c:if>							
					
				</c:if>		
			</div>	
		</nav>
	</header>




	<section class="parallax">
	
		<div class="wrapper">
			<span class="icon-close"><ion-icon name="close-outline"></ion-icon></span>

			<div class="form-box login">
				<h2>Login</h2>
				<form id="login_form" method="post">
					<div class="input-box">
						<span class="icon"><ion-icon name="person-outline"></ion-icon>
						</span> 
						<input class="id_iput" name="memberId">
						<label>Id</label>
					</div>
					<div class="input-box">
						<span class="icon"><ion-icon name="lock-open-outline"></ion-icon>
						</span> <input class="pw_iput" name="memberPw">
						<label>Password</label>
					</div>
					<div class="remember-forgot">
						<a style="cursor: pointer;"
							onclick="location='NutsServlet?command=check_form'">Forgot
							Password?</a>
					</div>
					
					
					<input type="button" class="login_button" value="Login" style="background: #359381; border: none; outline: none; border-radius: 6px; cursor: pointer; width: 100%; height: 70px; text-align: center; ">
					<c:if test="${result ==0}">
					<div class="login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
					</c:if>
					
					
					<div class="login-register">
						<p>
							아직 계정이 없으신가요? <a href="#" class="register-link">Register </a>
						</p>
					</div>
				</form>
			</div>


			<div class="form-box register">
				<h2>Registration</h2>
				<form id="join_form" method="post">
					<div class="input-box">
						<span class="icon"><ion-icon name="person-circle-outline"></ion-icon>
						</span> <input class="user_input" name="memberName"> <label>UserName</label>
						<span class="final_name_ck">이름을 입력해주세요.</span>
					</div>

					<div class="input-box">
						<span class="icon"><ion-icon name="person-outline"></ion-icon>
						</span> <input class="id_input" name="memberId"> <label>Id</label> <input
							type="hidden" name="reid"> 
							<span class="id_input_re_1">사용 가능한 아이디입니다.</span>
							<span class="id_input_re_2">아이디가 이미 존재합니다.</span>	
							<span class="final_id_ck"></span>
					</div>




					<div class="input-box">
						<span class="icon"><ion-icon name="lock-open-outline"></ion-icon>
						</span> <input class="pw_input" name="memberPw"> <label>Password</label>
					</div>
					
					
					<div class="input-box">
						<span class="icon"><ion-icon name="lock-open-outline"></ion-icon>
						</span> <input class="pwck_input"> <label>Retype
							Password</label>
							<span class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
							<span class="pwck_input_re_1">비밀번호가 일치합니다.</span>
							<span class="pwck_input_re_2">비밀번호가 일치하지 않습니다.</span>
					</div>
					
					<div class="input-box">
						
						<span class="icon"><ion-icon name="lock-open-outline"></ion-icon></span> 
						
						<input class="mail_input" name="memberMail"> <label>E-Mail</label>
							<span class="final_mail_ck">이메일을 입력해주세요.</span>
							
						<span class="mail_input_box_warn"></span>
						
						
					</div>
					
					<div class="input-box">
					<span class="icon"><ion-icon name="lock-open-outline"></ion-icon></span> 
						
							<div class="mail_check_input_box" id="mail_check_input_box_false">
								<input class="mail_check_input" disabled="disabled"> 
							</div>
							<div class="mail_check_button" style="background: #359381; border: none; outline: none; border-radius: 6px; cursor: pointer; width: 25%; height: 30px; text-align: center; margin-top: -8px; margin-left: 210px;">
						    <span>Send</span>
							</div>

							<div class="clearfix"></div>
							<span   id="mail_check_input_box_warn"></span>
						</div>	
					
					<div class="input-box">
						<span class="icon"><ion-icon name="lock-open-outline"></ion-icon></span> 
						
						
						
						<div class="address_name">주소</div>
							<div class="address_input_1_wrap">
								<div class="address_input_1_box">
									<input class="address_input_1" name="memberAddr1" readonly="readonly">
								</div>
								<div class="address_button" onclick="execution_daum_address()"  style="background: #359381; border: none; outline: none; border-radius: 6px; cursor: pointer; width: 25%; height: 30px; text-align: center; margin-top: -18px; margin-left: 210px;">
									<span>주소 찾기</span>
								</div>
								<div class="clearfix"></div>
							</div>
							
							
							
							<span class="final_addr_ck">주소를 입력해주세요.</span>
					</div>
					
					<div class="input-box">
						<div class ="address_input_2_wrap">
								<div class="address_input_2_box">
									<input class="address_input_2" name="memberAddr2" readonly="readonly">
								</div>
							</div>
							
					</div>
					
					<div class="input-box">
						
							
							
							<div class ="address_input_3_wrap">
								<div class="address_input_3_box">
									<input class="address_input_3" name="memberAddr3" readonly="readonly">
								</div>
							</div>
					</div>
					
					
					<div class="remember-forgot">I agree to the terms &
						conditions</div>
					<input type="button" class="join_button" value="Register" style="background: #359381; border: none; outline: none; border-radius: 6px; cursor: pointer; width: 25%; height: 30px; text-align: center; margin-top: -18px; margin-left: 210px;">
					<div class="login-register">
						<p>
							이미 계정이 있으신가요? <a href="#" class="login-link">Login </a>
						</p>
					</div>
				</form>
				
				
				
			</div>
		</div>
		<img src="resources/images/hill1.png" id="hill1"> <img
			src="resources/images/hill2.png" id="hill2"> <img src="resources/images/hill3.png"
			id="hill3"> <img src="resources/images/hill4.png" id="hill4"> <img
			src="resources/images/hill5.png" id="hill5"> <img src="resources/images/tree.png"
			id="tree">
		<h2 id="text">Nuts</h2>
		<img src="resources/images/leaf.png" id="leaf"> <img
			src="resources/images/plant.png" id="plant">
	</section>
	
	
	
	
	
	
	
	
	<section class="sec" style="margin-bottom: -40px; margin-top: 15px;">
		<h2>Nuts는 ...</h2>
		<p>회원들에게 필요한 약을 추천해주는 사이트입니다.</p>
		<br> <br>
	</section>
	<section class="chu">

		<div class="search__box">
			<div class="search__title">1,022,214 명이</div>
			<div class="search__title1" style="color: black">지금 필요한 영양성분을
				확인했어요.</div>
			<table>
				<tr>
					<td colspan="2" class="search__sub__title">나이</td>
				</tr>
				<tr>
					<td colspan="2"><input style="color:black;"  placeholder=" 만 13세 이상만 가능합니다."
						class="search__input" type="text" /></td>
				</tr>
				<tr>
					<td colspan="2" class="search__sub__title">몸무게</td>
				</tr>
				<tr>
					<td colspan="2"><input  style="color:black;"  placeholder=" kg" class="search__input"
						type="text" /></td>
				</tr>




				<tr>
					<td class="search__sub__title">생년월일</td>
					<td class="search__sub__title">성별</td>
				</tr>
				<tr>
					<td><input class="search__input" style="color:black;"  type="date"></td>
					<td><input name="sex" class="search__input" type="radio">male</td>
					<td><input name="sex" class="search__input" type="radio">female</td>
				</tr>
				
			</table>
			<div class="search__button">
				<button type="button" class="btn btn-success" onclick="return go_ai()">나에게 부족한 성분은?</button>

			</div>
		</div>

	</section>


	 <main>
		<section class="mol">
			<section class="mol2">

				<div class="sec__title">넛츠 둘러보기</div>

				<div class="container">
					<div class="box mySwiper">
						<div class="content swiper-wrapper">
							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/allList2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;">전체</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i>
									</div>

									<button style="--clr: #ff0f5b" onclick="window.location.href = 'NutsServlet?command=AllList_form'; return false;">View More</button>
								</div>
							</div>

							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/eye2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;">눈건강</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bx-star' style="--clr: #be01fe"></i>
									</div>

									<button style="--clr: #be01fe" onclick="window.location.href = 'NutsServlet?command=kindpick_form&kind=1'; return false;">View More</button>
								</div>
							</div>

							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/kidney2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;">간건강</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #fea401"></i> <i
											class='bx bxs-star' style="--clr: #fea401"></i> <i
											class='bx bxs-star' style="--clr: #fea401"></i> <i
											class='bx bxs-star' style="--clr: #fea401"></i> <i
											class='bx bx-star' style="--clr: #fea401"></i>
									</div>

									<button style="--clr: #fea401" onclick="window.location.href = 'NutsServlet?command=kindpick_form&kind=3'; return false;">View More</button>
								</div>
							</div>

							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/intestinal2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;"> 장건강</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bx-star' style="--clr: #ff0f5b"></i> <i
											class='bx bx-star' style="--clr: #ff0f5b"></i>
									</div>

									<button style="--clr: #ff0f5b" onclick="window.location.href = 'NutsServlet?command=kindpick_form&kind=6'; return false;">View More</button>
								</div>
							</div>

							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/Skin2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;">피부건강</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i>
									</div>

									<button style="--clr: #be01fe"  onclick="window.location.href = 'NutsServlet?command=kindpick_form&kind=4'; return false;">View More</button>
								</div>
							</div>

							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/bone2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;">뼈건강</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #fea401"></i> <i
											class='bx bxs-star' style="--clr: #fea401"></i> <i
											class='bx bxs-star' style="--clr: #fea401"></i> <i
											class='bx bx-star' style="--clr: #fea401"></i> <i
											class='bx bx-star' style="--clr: #fea401"></i>
									</div>

									<button style="--clr: #fea401" onclick="window.location.href = 'NutsServlet?command=kindpick_form&kind=2'; return false;">View More</button>
								</div>
							</div>

							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/blood2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;">혈관건강</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bxs-star' style="--clr: #ff0f5b"></i> <i
											class='bx bx-star' style="--clr: #ff0f5b"></i> <i
											class='bx bx-star' style="--clr: #ff0f5b"></i>
									</div>

									<button style="--clr: #ff0f5b" onclick="window.location.href = 'NutsServlet?command=kindpick_form&kind=5'; return false;">View More</button>
								</div>
							</div>

							<div class="card swiper-slide">
								<div class="card-content">
									<div class="image">
										<img src="product_images/vitality2.png" alt="">
									</div>
									<!--문자입력-->
									<div class="name-profession">
										<span class="name" style="color: #fff;">피로회복</span> <span
											class="profession" style="color: #fff;">보기</span>
									</div>

									<div class="rating">
										<i class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bxs-star' style="--clr: #be01fe"></i> <i
											class='bx bx-star' style="--clr: #be01fe"></i>
									</div>

									<button style="--clr: #be01fe" onclick="window.location.href = 'NutsServlet?command=kindpick_form&kind=7'; return false;">View More</button>
								</div>
							</div>

						</div>

						<div class="swiper-button-next"></div>
						<div class="swiper-button-prev"></div>
						<div class="swiper-pagination"></div>
					</div>
				</div>


			</section>
			
			
			
			<section>
				<div class="sec__title">BEST 상품을 만나보세요</div>
				<div class="choo__box"
					style="  display: grid;
				    grid-template-columns: 1fr 1fr 1fr 1fr;
				    grid-gap: 10px;
				    margin-top: 20px;">
					<c:forEach items="${bestProductList}" var="productVO">
						<div id="item">
							<a
								 href="/goodsDetail/${productVO.pillId}">
								<img src="resources/product_images/${productVO.image}" />
								<h3>상품명 : ${productVO.pillName}</h3>
								<p>가격 : ${productVO.pillPrice}</p>
								<div class="info1">성분 표를 반드시 확인하세요</div>
								<div class="info3">
									<span class="star">⭐⭐⭐⭐⭐</span> <span class="count">185</span>
									<span class="type">슈퍼호스트</span>
								</div>
							</a>
						</div>
					</c:forEach>


				</div>
			</section>
			<section>
				<div class="sec__title">NEW 신상 아이템</div>
				<div class="home__box">

					<c:forEach items="${newProductList}" var="productVO">
						<div id="item">
							<a
								href="/goodsDetail/${productVO.pillId}">
								<img src="resources/product_images/${productVO.image}" />
								<h3>상품명 : ${productVO.pillName}</h3>
								<p>가격 : ${productVO.pillPrice}</p>
								<div class="info1">성분 표를 반드시 확인하세요</div>
								<div class="info3">
									<span class="star">⭐⭐⭐⭐</span> <span class="count">125</span> <span
										class="type">슈퍼호스트</span>
								</div>
							</a>
						</div>
					</c:forEach>

				</div>
			</section>
			<section>
				<div class="sec__title">넛츠의 다양한 이용후기를 만나보세요!</div>
				<div class="sec__content" style="color: #fff;">여러분의 건강 꿀팁을 알려주세요.</div>
			</section>

		</section>
	</main>
	<section class="pan">
		<div class="ad2">
			<button type="button" style="top: 4000;" class="btn btn-light" onclick="location='NutsServlet?command=board_list'">게시판
				바로가기</button>

			<h1 id="event" style="top: 3670;">ENJOY YOUR HEALTH</h1>
			<img class="photo" style="top: 3670;"
				src="https://image.istarbucks.co.kr/upload/common/img/main/2022/2022_NewYear_pick_img.png" />
		</div>
		
	</section> 








	<script type="module"
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

	<script type="text/javascript" src="main.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>
	<script type="text/javascript">
	var swiper = new Swiper(".mySwiper", {
	    slidesPerView: 2.5,
	    spaceBetween: 50,
	    
	    grabCursor: true,
	    pagination: {
	        el: ".swiper-pagination",
	        clickable: true,
	        dynamicBullets: true,
	    },
	    navigation: {
	        nextEl: ".swiper-button-next",
	        prevEl: ".swiper-button-prev",
	    },
	});
	 // 링크 클릭 이벤트 처리
	  document.getElementById("ai-link").addEventListener("click", function(event) {
	    event.preventDefault(); // 링크의 기본 동작을 막음
	    go_ai(); // go_ai 함수 호출
	  });

	  // go_ai 함수
	  function go_ai() {
	    location.href = "ai/pill.html"; // qna.html 페이지로 이동
	  }
	</script>
	<footer>
		<div class="footer-container">
			<div class="footer-nav">
				<ul>
				<a href="NutsServlet?command=admin_login_form" style="width:100px;"> ADMIN)</a>
					<li><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			<div class="footer-follow">
				<span>Follow us:</span> <a href="#" class="social-icon"><i
					class="fa fa-facebook"></i></a> <a href="#" class="social-icon"><i
					class="fa fa-twitter"></i></a> <a href="#" class="social-icon"><i
					class="fa fa-instagram"></i></a>
			</div>
			<div>
				 <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed dictum elit in velit pretium varius. Donec rhoncus euismod mi, eu feugiat purus cursus in.</p>
			</div>
		</div>
	</footer>

<script type="text/javascript">



let text = document.getElementById("text");
let leaf = document.getElementById('leaf');
let hill1 = document.getElementById('hill1');
let hill4 = document.getElementById('hill4');
let hill5 = document.getElementById('hill5');


let handleScroll = () => {
let value = window.scrollY;

// 스크롤 위치에 따라 요소들의 위치 조정
text.style.marginTop = value * 2.5 +'px';
leaf.style.top = value * -1.5 +'px';
leaf.style.left = value * 1.5 +'px';
hill5.style.left = value * 1.5 +'px';
hill4.style.left = value * -1.5 +'px';
hill1.style.left = value * 1 +'px';

// 스크롤 위치가 600이상이 되면 스크롤 이벤트 제거
if(value >= 300){
    window.removeEventListener('scroll', handleScroll);
}
};

//스크롤 이벤트 추가
window.addEventListener('scroll', handleScroll);

//스크롤 위치가 300 이하로 내려가면 스크롤 이벤트 다시 추가
window.addEventListener('scroll', ()=>{
let value = window.scrollY;
if(value < 300){
    window.addEventListener('scroll', handleScroll);
}
});



const wrapper = document.querySelector('.wrapper');
const loginLink = document.querySelector('.login-link');
const registerLink = document.querySelector('.register-link');

const btnPopup = document.querySelector('.btnLogin-popup');
const iconClose = document.querySelector('.icon-close');

registerLink.addEventListener('click',()=>{
wrapper.classList.add('active');
});

loginLink.addEventListener('click',()=>{
wrapper.classList.remove('active');

});

btnPopup.addEventListener('click',()=>{
wrapper.classList.add('active-popup');
});
iconClose.addEventListener('click',()=>{
wrapper.classList.remove('active-popup');
});





let mainText = document.querySelector('#event');
let ticking = false;

window.addEventListener("scroll", function() {

if (!ticking) {
    window.requestAnimationFrame(function() {
    let value = window.scrollY;
    console.log("scrollY",value);
    if (value < 3000) {
        mainText.style.animation = "disappear 1s ease-out forwards";
    }
    else if(value > 3700){
        mainText.style.animation = "disappear 1s ease-out forwards";
    }
    else{
        mainText.style.animation = "slide 1s ease-out"
    }
    ticking = false;
    });
    ticking = true;
}
});



var code = "";				//이메일전송 인증번호 저장위한 코드

/* 유효성 검사 통과유무 변수 */
var idCheck = false;			// 아이디
var idckCheck = false;			// 아이디 중복 검사
var pwCheck = false;			// 비번
var pwckCheck = false;			// 비번 확인
var pwckcorCheck = false;		// 비번 확인 일치 확인
var nameCheck = false;			// 이름
var mailCheck = false;			// 이메일
var mailnumCheck = false;		// 이메일 인증번호 확인
var addressCheck = false 		// 주소

//아이디 중복검사
$('.id_input').on("propertychange change keyup paste input", function(){

	/* console.log("keyup 테스트"); */
	
	var memberId = $('.id_input').val();			// .id_input에 입력되는 값
	var data = {memberId : memberId}				// '컨트롤에 넘길 데이터 이름' : '데이터(.id_input에 입력되는 값)'
	
	$.ajax({
		type : "post",
		url : "/member/memberIdChk",
		data : data,
		success : function(result){
			// console.log("성공 여부" + result);
			if(result != 'fail'){
				$('.id_input_re_1').css("display","inline-block");
				$('.id_input_re_2').css("display", "none");	
				idckCheck = true;
			} else {
				$('.id_input_re_2').css("display","inline-block");
				$('.id_input_re_1').css("display", "none");
				idckCheck = false;
			}	
		}// success 종료
	}); // ajax 종료	

});// function 종료

/* 인증번호 이메일 전송 */
$(".mail_check_button").click(function(){
	
	var email = $(".mail_input").val();			// 입력한 이메일
	var cehckBox = $(".mail_check_input");		// 인증번호 입력란
	var boxWrap = $(".mail_check_input_box");	// 인증번호 입력란 박스
	var warnMsg = $(".mail_input_box_warn");	// 이메일 입력 경고글
	
	/* 이메일 형식 유효성 검사 */
	if(mailFormCheck(email)){
		warnMsg.html("이메일이 전송 되었습니다. ");
		warnMsg.css("display", "inline-block");
	} else {
		warnMsg.html("올바르지 못한 이메일 형식입니다.");
		warnMsg.css("display", "inline-block");
		return false;
	}	
	
	$.ajax({
		
		type:"GET",
		url:"/member/mailCheck?email=" + email,
		success:function(data){
			
			//console.log("data : " + data);
			cehckBox.attr("disabled",false);
			boxWrap.attr("id", "mail_check_input_box_true");
			code = data;
			
		}
				
	});
	
});
/* 인증번호 비교 */
$(".mail_check_input").blur(function(){
	
	var inputCode = $(".mail_check_input").val();		// 입력코드	
	var checkResult = $("#mail_check_input_box_warn");	// 비교 결과 	
	
	if(inputCode == code){							// 일치할 경우
		checkResult.html("인증번호가 일치합니다.");
		checkResult.attr("class", "correct");		
		mailnumCheck = true;
	} else {											// 일치하지 않을 경우
		checkResult.html("인증번호를 다시 확인해주세요.");
		checkResult.attr("class", "incorrect");
		mailnumCheck = false;
	}	
	
});
/* 입력 이메일 형식 유효성 검사 */
function mailFormCheck(email){
	var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	return form.test(email);
}

/* 다음 주소 연동 */
function execution_daum_address(){
	
   new daum.Postcode({
       oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
           
           // 각 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var addr = ''; // 주소 변수
           var extraAddr = ''; // 참고항목 변수

           //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
           if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
               addr = data.roadAddress;
           } else { // 사용자가 지번 주소를 선택했을 경우(J)
               addr = data.jibunAddress;
           }

           // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
           if(data.userSelectedType === 'R'){
               // 법정동명이 있을 경우 추가한다. (법정리는 제외)
               // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
               if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                   extraAddr += data.bname;
               }
               // 건물명이 있고, 공동주택일 경우 추가한다.
               if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
               }
               // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
               if(extraAddr !== ''){
                   extraAddr = ' (' + extraAddr + ')';
               }
               // 주소변수 문자열과 참고항목 문자열 합치기
     			addr += extraAddr;
           
           } else {
               addr += ' ';
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           $(".address_input_1").val(data.zonecode);
           //$("[name=memberAddr1]").val(data.zonecode);	// 대체가능
           $(".address_input_2").val(addr);
           //$("[name=memberAddr2]").val(addr);			// 대체가능
           // 상세주소 입력란 disabled 속성 변경 및 커서를 상세주소 필드로 이동한다.
           $(".address_input_3").attr("readonly",false);
           $(".address_input_3").focus();
           
       }
   }).open();   
   
}






$(document).ready(function(){
	//회원가입 버튼(회원가입 기능 작동)
	$(".join_button").click(function(){
		
		/* 입력값 변수 */
		var id = $('.id_input').val(); 				// id 입력란
		var pw = $('.pw_input').val();				// 비밀번호 입력란
		var pwck = $('.pwck_input').val();			// 비밀번호 확인 입력란
		var name = $('.user_input').val();			// 이름 입력란
		var mail = $('.mail_input').val();			// 이메일 입력란
		var addr = $('.address_input_3').val();		// 주소 입력란
		
		/* 아이디 유효성검사 */
		if(id == ""){
			$('.final_id_ck').css('display','block');
			idCheck = false;
		}else{
			$('.final_id_ck').css('display', 'none');
			idCheck = true;
		}
		
		/* 비밀번호 유효성 검사 */
		if(pw == ""){
			$('.final_pw_ck').css('display','block');
			pwCheck = false;
		}else{
			$('.final_pw_ck').css('display', 'none');
			pwCheck = true;
		}
		
		/* 비밀번호 확인 유효성 검사 */
		if(pwck == ""){
			$('.final_pwck_ck').css('display','block');
			pwckCheck = false;
		}else{
			$('.final_pwck_ck').css('display', 'none');
			pwckCheck = true;
		}
		
		/* 이름 유효성 검사 */
		if(name == ""){
			$('.final_name_ck').css('display','block');
			nameCheck = false;
		}else{
			$('.final_name_ck').css('display', 'none');
			nameCheck = true;
		}		
		
		/* 이메일 유효성 검사 */
		if(mail == ""){
			$('.final_mail_ck').css('display','block');
			mailCheck = false;
		}else{
			$('.final_mail_ck').css('display', 'none');
			mailCheck = true;
		}		
		
		/* 주소 유효성 검사 */
		if(addr == ""){
			$('.final_addr_ck').css('display','block');
			addressCheck = false;
		}else{
			$('.final_addr_ck').css('display', 'none');
			addressCheck = true;
		}		
		
		/* 최종 유효성 검사 */
		if(idCheck&&idckCheck&&pwCheck&&pwckCheck&&pwckcorCheck&&nameCheck&&mailCheck&&mailnumCheck&&addressCheck ){
			alert("회원가입이 완료되었습니다");
			$("#join_form").attr("action", "/member/join");
			$("#join_form").submit();			
			
		}		
		
		return false;

	});
});

/* 비밀번호 확인 일치 유효성 검사 */

$('.pwck_input').on("propertychange change keyup paste input", function(){
	
	var pw = $('.pw_input').val();
	var pwck = $('.pwck_input').val();
	$('.final_pwck_ck').css('display', 'none');
	
	if(pw == pwck){
		$('.pwck_input_re_1').css('display','block');
		$('.pwck_input_re_2').css('display','none');
		pwckcorCheck = true;
	}else{
		$('.pwck_input_re_1').css('display','none');
		$('.pwck_input_re_2').css('display','block');
		pwckcorCheck = false;
	}
	
	
});


$(".login_button").click(function(){
    
	$("#login_form").attr("action", "/member/login.do");
    $("#login_form").submit();
        
    });
</script>
</body>
</html>