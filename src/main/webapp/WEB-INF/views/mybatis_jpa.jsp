<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript">
  function check(){
     if($.trim($("#username").val()) == ""){
        alert('username을 입력하세요!');
        $('#username').val('').focus();
        return false;
     }
     
     if($.trim($('#useraddr').val()) == ''){
        alert("address를 입력하세요!");
        $("#useraddr").val("").focus();
        return false;
     }
  }
</script>
</head>
<body>
 <h1>${content_title}</h1>
 <form method="post" onsubmit="return check()">
  <%-- action속성을 생략하면 이전 매핑주소가 action속성값이 된다.매핑주소가 같으면 method방식으로 구분
  한다. --%>
  <p>User Name : <input id="username" name='username' size='14' ></p>
                 <%--type속성을 생략하면 기본값이 text이다. --%>
  <p>Address : <input id="useraddr" name="useraddr" size="36" ></p>
  <p><input type="submit" value="전송" > <input type="Reset" value="취소" 
  onclick="$('#username').focus()" ></p>               
 </form>
</body>
</html>