<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Calendar.js"></script>
<script type="text/javascript">
	$(function() {
		$("#query").click(function() {
			$("[name='pageNum']").val(1);
			$("form:first").submit();
		});
	});
	function showMsg(msg,uuid){
		//top.document.getElementById("context-msg").style.display = "block";
		top.$('context-msg').style.display = "block";
		top.$('context-msg-text').innerHTML=msg;
		top.$('hid-action').value="actionName";
		top.lock.show();
	}
</script>
<div class="content-right">
	<div class="content-r-pic_w">
		<div style="margin:8px auto auto 12px;margin-top:6px">
			<span class="page_title">员工管理</span>
		</div>
	</div>
	<div class="content-text">
		<s:form action="emp_list" method="post">
			<div class="square-o-top">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
					style="font-size:14px; font-weight:bold; font-family:"黑体";">
					<tr>
						<td height="30">用&nbsp;户&nbsp;名</td>
						<td><input type="text" size="14" /></td>
						<td>真实姓名</td>
						<td><input type="text" size="14" /></td>
						<td>电&nbsp;&nbsp;&nbsp;&nbsp;话</td>
						<td><input type="text" size="14" /></td>
						<td>性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
						<td>
							<select class="kuan">
								<option value="-1">----请-选-择----</option>
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</td>
							
						<td width="70"><a href="emp_preInput.action"> <img src="images/can_b_02.gif" border="0" /> </a></td>
					</tr>
					<tr>
						<td  height="30">电子邮件</td>
						<td><input type="text" size="14" /></td>
						<td>登录时间</td>
						<td>
							<input type="text"  size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>登录时间</td>
						<td>
							<input type="text" size="14" onfocus="c.showMoreDay=false;c.show(this);" readonly="true"/>
						</td>
						<td>部门名称</td>
						<td>
							<select class="kuan">
								<option value="-1">----请-选-择----</option>
								<s:iterator value="deptList">
									<option value="${uuid}">${name}</option>
								</s:iterator>
							</select>
						</td>
						<td><a id="query"> <img src="images/can_b_01.gif" border="0" /> </a></td>
					</tr>
				</table>
			</div>
			<!--"square-o-top"end-->
			<div class="square-order">
				<table width="100%" border="1" cellpadding="0" cellspacing="0">
					<tr align="center"
						style="background:url(images/table_bg.gif) repeat-x;">
						<td width="10%" height="30">用户名</td>
						<td width="10%">真实姓名</td>
						<td width="5%">性别</td>
						<td width="12%">出生日期</td>
						<td width="10%">电话</td>
						<td width="12%">电子邮件</td>
						<td width="9%">所属部门</td>
						<td width="16%">最后登录时间</td>
						<td width="16%">操作</td>
					</tr>
					<s:iterator value="empList">
						<tr align="center" bgcolor="#FFFFFF">
							<td width="13%" height="30">${name}</td>
							<td>${realName}</td>
							<td>${sex == 1? '男':'女'}</td>
							<td><s:date name="birthday" format="yyyy-MM-dd"/></td>
							<td>${telephone}</td>
							<td>${email}</td>
							<td>${dept.name}</td>
							<td>${lastLoginTime}</td>
							<td>
								<img src="images/icon_3.gif" />
								<span style="line-height:12px; text-align:center;">
									<s:a action="emp_preInput" cssClass="xiu">修改
										<s:param name="em.uuid">${uuid}</s:param>
									</s:a>
								</span>
								<img src="images/icon_04.gif" />
								<span style="line-height:12px; text-align:center;">
									<a href="javascript:void(0)" class="xiu" onclick="showMsg('是否删除该项数据？',318)">删除</a>
								</span>
							</td>
						</tr>
					</s:iterator>
				</table>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="51%">&nbsp;</td>
						<td width="13%">共${totalNum}条记录
						<td width="6%">
							<a id="fir" class="sye">首&nbsp;&nbsp;页</a>
						</td>
						<td width="6%">
							<a id="pre" class="sye">上一页</a>
						</td>
						<td width="6%">
							<a id="next" class="sye">下一页</a>
						</td>
						<td width="6%">
							<a id="last" class="sye">末&nbsp;&nbsp;页</a>
						</td>
						<td width="12%">当前第<span style="color:red;">${currentPage}</span>/${maxPage}页</td>
					</tr>
				</table>

				<s:hidden name="currentPage"/>
				<script>
					var currentPage = ${currentPage};
					var maxPage = ${maxPage};

					if(maxPage == 1){
						$("#fir").css("display", "none");
						$("#pre").css("display", "none");
						$("#next").css("display", "none");
						$("#last").css("display", "none");
					}else if(currentPage == 1){
						$("#fir").css("display", "none");
						$("#pre").css("display", "none");
						$("#next").css("display", "inline");
						$("#last").css("display", "inline");
					}else if(currentPage == maxPage){
						$("#fir").css("display", "inline");
						$("#pre").css("display", "inline");
						$("#next").css("display", "none");
						$("#last").css("display", "none");
					}else{
						$("#fir").css("display", "inline");
						$("#pre").css("display", "inline");
						$("#next").css("display", "inline");
						$("#last").css("display", "inline");
					}

					$(function () {
						$("#next").click(function () {
							$("[name='currentPage']").val($("[name='currentPage']").val()*1+1);
							$("form:first").submit();
						});
					});
					$(function () {
						$("#pre").click(function () {
							$("[name='currentPage']").val($("[name='currentPage']").val()-1);
							$("form:first").submit();
						});
					});
					$(function () {
						$("#fir").click(function () {
							$("[name='currentPage']").val(1);
							$("form:first").submit();
						});
					});
					$(function () {
						$("#last").click(function () {
							$("[name='currentPage']").val(${maxPage});
							$("form:first").submit();
						});
					});
				</script>

			</div>
		</s:form>
	</div>
	<div class="content-bbg"></div>
</div>
