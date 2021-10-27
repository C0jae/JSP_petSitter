<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script>
    function wlose() {
      opener.window.document.frmReg.nick.value = frmre.nick.value;
    }
  </script>
</head>
<body>
       <h3>아이디중복체크</h3>
       <form action="NickCheck.do" name="frmre" method="post">
       <table class="table">
         <tr>
           <td>
            Nick:<input type=text name="nick" id="nick" class="input-nick" size=15>
  	          <input type=submit  value="중복체크" id="NickcheckBtn"class="btn btn-input btn-primary" onclick="wlose()">
           </td>
         </tr>
       </table>
  		</form>
</body>
</html>