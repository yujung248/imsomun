<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%-- <%@ page import ="egovframework.com.cmm.LoginVO" %> --%>
<%@ page import="egovframework.let.shop.mng.review.service.ReviewMngVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
            #menuTable {border-collapse: collapse; display: inline-block; width: 340px;}
            #menuTable td{width: 170px;}
            #menuTable td button{font-weight: bold; height: 30px; border: 1px solid blue;
                                    width: 70px; background: #5AAFFF; color: white; cursor: pointer;}
            #snakeTable {border-collapse: collapse; display: inline-block;}
            #snakeTable td{border: 1px solid blue; width: 13px; height: 13px;}
            .snake{background-color: #5AAFFF;}
            .food{background-color: #CCCCCC;}
            .center{text-align: center;}
            #controller {border-collapse: collapse; display: inline-block; margin-top: 20px;}
            #controller td{border: none; text-align: center; font-size: 20pt; color: white;}
            .btn{width: 80px; height: 80px; background: #CCCCCC; border-radius: 50px;}
            .alignLeft{text-align: left;}
            .alignRight{text-align: right;}
        </style>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" type="text/javascript"></script>
<title>mini</title>
<script>
            //난수 생성 함수
            function generateRandom (min, max) {
                var ranNum = Math.floor(Math.random()*(max-min+1)) + min;
                    return ranNum;
            }
 
            ////뱀게임///
 
            var score = 0;
 
            var LR = 0; // 좌우 방향
            var TB = 1; // 위아래 방향
 
            var mapSize = 25; //map size
 
            var gameInterval;
 
 
            // init map
            function initMap(){
                var tableCode = '';
                for(var i=0; i<mapSize; i++) {
                    tableCode += '<tr>';
 
                    var rowCode = '';
                    for(var j=0; j<mapSize; j++) {
                        rowCode += '<td id="block'+i+'_'+j+'"></td>';
                    }
 
                    tableCode += rowCode + '</tr>';
                    $('#snakeTable').html(tableCode);
                }
            }
 
            //snake
            var snake = new Array();
            //food
            var food = new Array();
 
            // init snake
            function initSnake(){
                snake = [];
                snake.push([0,1]);
                drawSnake();
            }
 
            //뱀 그리기
            function drawSnake() {
                var state = '';
                $('#snakeTable td').removeClass('snake');
                for(var i=0;i<snake.length;i++) {
                    $('#block'+snake[i][0]+'_'+snake[i][1]).addClass('snake');
                    //먹이 먹었을 때
                    if($('#block'+snake[i][0]+'_'+snake[i][1]).hasClass('food')){
                        score++; // 점수 증가
                        $('#score').text(score); //점수 반영
                        food.pop(); // 먹이 제거
                        initFood(); // 새로운 먹이 추가
                        //뱀 꼬리 늘리기
                        state = 'eat';
                    }
                }
                return state;
            }
 
            // 먹이 초기화
            function initFood(){
                var x;
                var y;
 
                do{
                     x = generateRandom(0,mapSize-1);
                     y = generateRandom(0,mapSize-1);
                }while($('#block'+x+'_'+y).hasClass('snake')); // 뱀이랑 겹치면 다시
 
                food = [];
                food.push([x, y]);
                drawFood();
            }
 
            //먹이 그리기
            function drawFood() {
                $('#snakeTable td').removeClass('food');
                for(var i=0;i<food.length;i++) {
                    $('#block'+food[i][0]+'_'+food[i][1]).addClass('food');
                }
            }
 
 
            // move
            function move() {
                var head = new Array();
                head[0] = snake[0][0];
                head[1] = snake[0][1];
 
                // 벽을 만난건지 체크
                var tmp = head[0]+1*TB;
                if(tmp >= 0 && tmp < mapSize) {
                    head[0] = tmp;
                }else {
                    alert('점수 : '+score);
                    end();
                    initAll();
                    return;
                }
 
                tmp = head[1]+1*LR;
                if(tmp >= 0 && tmp < mapSize) {
                    head[1] = tmp;
                }else {
                    alert('점수 : '+score);
                    $('#totalScore').text(score);
                    end();
                    initAll();
                    return;
                }
 
                // 몸통을 만난건지 체크
                if($('#block'+head[0]+'_'+head[1]).hasClass('snake')){
                    alert('점수 : '+score);
                    end();
                    initAll();
                    return;                    
                }
 
 
                snake.unshift(head);
 
                if(drawSnake() != 'eat') { //먹은게 아니면
                    snake.pop(); //꼬리 연장 X
                }
            }
 
 
            function left() {
                if(TB == 0) return; // 반대방향으로 방향전환 불가
                LR = -1;
                TB = 0;
            }
            function right() {
                if(TB == 0) return; // 반대방향으로 방향전환 불가
                LR = 1;
                TB = 0;
            }
            function up() {
                if(LR == 0) return; // 반대방향으로 방향전환 불가
                LR = 0;
                TB = -1;
            }
            function down() {
                if(LR == 0) return; // 반대방향으로 방향전환 불가
                LR = 0;
                TB = 1;
            }
 
 
            $(document).on('click', '#startBtn', function(){
                end();
                start();
            });
 
            $(document).on('click', '.btn', function(){
                var key = $(this).attr('data-key');
                if(key == 'up') {
                    up();
                }else if(key == 'down') {
                    down();
                }else if(key == 'left') {
                    left();
                }else if(key == 'right') {
                    right();
                }
            });
 
            $(document).on('mouseover', '.btn', function(){
                $(this).css('background', '#5AAFFF');
 
                var key = $(this).attr('data-key');
                if(key == 'up') {
                    up();
                }else if(key == 'down') {
                    down();
                }else if(key == 'left') {
                    left();
                }else if(key == 'right') {
                    right();
                }
            });
 
            $(document).on('keydown', 'body', function(event){
                if(event.key == 'ArrowUp') {
                    $('#up_btn').css('background', '#5AAFFF');
                    up();
                }else if(event.key == 'ArrowDown') {
                    $('#down_btn').css('background', '#5AAFFF');
                    down();
                }else if(event.key == 'ArrowLeft') {
                    $('#left_btn').css('background', '#5AAFFF');
                    left();
                }else if(event.key == 'ArrowRight') {
                    $('#right_btn').css('background', '#5AAFFF');
                    right();
                }
            });
 
            $(document).on('mouseout', '.btn', function(){
                $(this).css('background', '#CCCCCC');
            });
 
            $(document).on('keyup', 'body', function(){
                $('.btn').css('background', '#CCCCCC');
            });
 
            function initAll() {
                score = 0; // 점수 초기화
                initMap(); // 맵 초기화
                initFood(); // 먹이 초기화
                initSnake(); // init snake
                LR = 0; // 좌우 방향 초기화
                TB = 1; // 위아래 방향 초기화
            }
 
            function start(){
                gameInterval = setInterval(move, 50);
            }
 
            function end() {
                clearInterval(gameInterval);
            }
 
            $(document).ready(function(){
                initAll();
            });
 
        </script>
</head>
<body>
<%@ include file="../../inc/EgovShopTop.jsp"%>
<%@ include file="../../inc/EgovShopHeader.jsp"%>

<div class="container text-center">
	<br/><br/><br/>
		<h1>30점넘으면 아이스크림 사준다.</h1>
		
		 <div class='center'>
            <table id='menuTable'>
                <tr>
                    <td class='alignLeft'>
                        <button id='startBtn'>시작</button>
                    </td>
                    <td class='alignRight'>
                        <span>점수 : <span id='score'>0</span></span>
                        <span>최고 점수 :<span id='totalScore'>0</span></span>
                    </td>
                </tr>
            </table>
        </div>
        <div class='center'>
            <table id='snakeTable'>
            </table>
        </div>
	</div>
<%@ include file="../../inc/EgovShopBottom.jsp"%>
</body>
</html>