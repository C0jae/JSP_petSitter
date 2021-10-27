<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script>
    function wClose() {
      opener.window.document.frmReg.id.value = frm.id.value;
      opener.window.document.frmReg.password.focus();
    }
  </script>
</head>
<body>
       <h3>아이디중복체크</h3>
       <form action="IdCheck.do" name="frm" method="post">
       <table class="table">
         <tr>
           <td>
            ID:<input type=text name="id" id=id class="input-sm" size=15>
  	          <input type=submit  value="중복체크" id="idcheckBtn" class="btn btn-sm btn-primary" onclick="wClose()">
           </td>
         </tr>
       </table>
  		</form>
</body>
</html>