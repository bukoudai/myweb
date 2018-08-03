<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%> 
    <%@ page trimDirectiveWhitespaces="true" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
    <%@ taglib uri="/struts-tags" prefix="s"  %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %> 
<jsp:include page="/WEB-INF/jsp/ui/uphead.jsp"></jsp:include>
<title>用户注册</title>
</head>  
<body >
<script type="text/javascript">
		
$(function(){
		//提交注册
		$("#registform").submit(function(){
			if(($("#username").val().trim()=="")||($("#password").val().trim()=="")){
				alert("用户名和密码不能为空或空格");
				$("#registsubmit").prop("disabled", false);
				return false;
			}
		   
			$.ajax({ 
		        type: "POST",
		        url:'${pageContext.request.contextPath}/Admin/registAjax',
		        contentType : "application/x-www-form-urlencoded; charset=utf-8",
		        data:$("#registform").serialize(),
		        dataType: "text",
		        success: function (data) {		        	
		        	if(data==1){
		        		alert("注册成功!")
		        	$("#registform .form-control").val("");
		        	}else{
		        		alert("注册失败,用户已存在")
		        	}
		        },
		        error: function () {
		        	alert("服务器忙");
		        }
		    })
		
		return false;
		});
		//密码验证
		$("#password").blur(function(){
			if($("#password").val().trim()==""){
				alert("密码不能为空或空格");
				$("#registsubmit").prop("disabled", true);
				return;
			}
				$("#registsubmit").prop("disabled", false);
			
			
		});
		//用户名验证
		$("#username").blur(function(){
			//判断是否为空
			if($("#username").val().trim()==""){
				alert("用户名为空或空格");
				$("#registsubmit").prop("disabled", true);
				$("#usernamespan").html("<font color='red'>用户名不可用</font>");
				return ;
			}
		   
			//判断是否重复
		    $.ajax({ 
		        type: "POST",
		        url:'${pageContext.request.contextPath}/Admin/checkUserNameAjax',
		        contentType : "application/x-www-form-urlencoded; charset=utf-8",
		        data:{"user.username":$("#username").val()},
		        dataType: "text",
		        success: function (data) {		        	
		        	if(1==data){
		        	$("#usernamespan").html("<font color='red'>用户名已存在</font>");
		        	}else if(0==data){
		        		$("#usernamespan").html("<font color='green'>用户名可用</font>");
		        		$("#registsubmit").prop("disabled", false);
		        	}else {
		        		alert("服务器忙");
		        	}
		        	
		        },
		        error: function () {
		        	alert("服务器忙");
		        }
		    })
		
		
		});
});
		
		
</script>

<form class="form-horizontal" style="margin-top:5px;"  id="registform">
			 
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" name="user.username" placeholder="请输入用户名">
			    <span id="usernamespan">输入用户名</span>
			    </div>
			    <span id="s1"></span>
			  </div>
			   <div class="form-group">
			    <label for="password" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      
			      <input type="password" class="form-control" id="password" name="user.password"  placeholder="请输入密码">
			    
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="confirmpwd" name="repassword"  placeholder="请输入确认密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="email" class="form-control" id="inputEmail3" name="user.email"  placeholder="Email">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="usercaption" name="user.name"  placeholder="请输入姓名">
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="user.sex" id="inlineRadio1" value="男" checked> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="user.sex" id="inlineRadio2" value="女"> 女
			</label>
			</div>
			  </div>	
			 <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control"  name="user.telephone" >		      
			    </div>
			  </div>	
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="date" class="form-control"  name="user.birthday" >		      
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control"  >
			      
			    </div>
			    <div class="col-sm-2">
			    <img src="./image/captcha.jhtml"/>
			    </div>
			    
			  </div>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input id="registsubmit" type="submit"  id="regBut" width="100" value="注册" />
			    </div>
			  </div>
</form>
<jsp:include page="/WEB-INF/jsp/ui/downui.jsp"></jsp:include>