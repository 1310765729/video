<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程管理</title>

<!-- Bootstrap -->
<link href='<c:url value="/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="/css/bootstrap-table.min.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="/css/bootstrap-editable.css"></c:url>'
	rel="stylesheet">

</head>
<body>
	<div class="container">

		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">智游公开课后台管理系统</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
				<li>
					<a href="#">首页 </a>
				</li>
				<li>
					<a href='<c:url value="/video"></c:url>'> 视频管理 </a>
				</li>
				<li>
					<a href='<c:url value="/speaker"></c:url>'>讲师管理</a>
				</li>
				<li  class="active">
					<a href='<c:url value="/course"></c:url>'>课程管理</a>
				</li>
				<li>
					<a href='<c:url value="/subject"></c:url>'>学科管理</a>
				</li>
			</ul>
			</div>
		</div>
		</nav>

		<a id="username">用户名</a>

		<div class="panel panel-info">
			<div class="panel-heading">课程管理</div>
			<div class="btn-group" role="group" aria-label="...">
					<button type="button" class="btn btn-default" id="course_add" onclick="showAddModal()">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					添加</button>
					<button type="button" class="btn btn-default" onclick="deleteSomeCourses()">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					删除</button>

			</div>
			

			<table class="table"></table>
		</div>
	</div>
	
	
	<div class="modal fade" id="model_update" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">更新课程</h4>
				</div>
				<div class="modal-body">
					<form>
						<input type="hidden" class="form-control" id="update_id">
						
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">课程名:</label>
							<select id="update_name">
							
							<c:forEach items="${courses}" var="course">
								<option value="${course.id }">${course.name }</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">课程描述:</label>
							<input type="text" class="form-control" id="update_describe">
						</div>
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">学科名:</label>
							<select id="update_subjectName">
							
							<c:forEach items="${subjects}" var="subject">
								<option value="${subject.id }">${subject.name }</option>
							</c:forEach>
							</select>
						</div>
						
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">创建时间:</label>
							<input type="text" class="form-control" id="update_createTime">
						</div>
						
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="showUpdateCourses()">更新</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="modal fade" id="model_add" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">添加课程</h4>
				</div>
				<div class="modal-body">
					<form>
						<input type="hidden" class="form-control" id="add_id">
						
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">课程名:</label>
							<select id="add_name">
							
							<c:forEach items="${courses}" var="course">
								<option value="${course.id }">${course.name }</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">课程描述:</label>
							<input type="text" class="form-control" id="add_describe">
						</div>
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">学科名:</label>
							<select id="add_subjectName">
							
							<c:forEach items="${subjects}" var="subject">
								<option value="${subject.id }">${subject.name }</option>
							</c:forEach>
							</select>
						</div>
						
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">创建时间:</label>
							<input type="text" class="form-control" id="add_createTime">
						</div>
						
						
						
					</form>
						
						
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="addCourses()">添加</button>
				</div>
			</div>
		</div>
	</div>


	<script src='<c:url value="/js/jquery-3.2.1.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap-table.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap-table-zh-CN.min.js"></c:url>'></script>
	<script src='<c:url value="/js/bootstrap-editable.min.js"></c:url>'></script>
	<script
		src='<c:url value="/js/bootstrap-table-editable.min.js"></c:url>'></script>

	<script>
	function updateCourses(id){
		$.ajax({
			url:"<c:url value='/course/"+id+"'></c:url>",
			success: function(responseVO){
				if(responseVO.errorCode==0){
					
					$('#update_id').val(responseVO.data.id); 
					$('#update_name').val(responseVO.data.name); 
					$('#update_describe').val(responseVO.data.describe);
					
					$('#update_subjectName').val(responseVO.data.subject.name);
					
					$('#update_createTime').val(responseVO.data.createTime);
				
					
					
					
					$('#model_update').modal('show');
					
				}
			},
			error:function(){
				
			}
		});
		
	}
		function showUpdateCourses(){
			
			var name=$('#update_name').val();
			var describe=$('#update_describe').val();
			var subjectId=$('#update_subjectName').val();
			var createTime=$('#update_createTime').val();
			var id=$('#update_id').val();
			
			//alert(name+courseName+subjectName+speakerName+id);
			
			$.ajax({
				url:"<c:url value='/courses/"+id+"'></c:url>",
				type: 'PUT',
				data: JSON.stringify({
					'id': id,
					'name': name,
					'subjectId':subjectId,
					'describe':describe,
					'createTime': createTime
					
					
				}),
				dataType:'json',
				contentType:'application/json',
				success:function(responseVO){
					if(responseVO.errorCode==0){
						
						$('#model_update').modal('hide');
						$('.table').bootstrapTable('refresh');
					}
				},
				error:function(error){
					/* alert("error"); */
				}
			});
		}
		
		function deleteCourses(id){
			$.ajax({
				url: "<c:url value='/courses/" + id + "'></c:url>",
				type: 'delete',
				success:function(responseVO){
					if(responseVO.errorCode==0){
						alert("删除成功");
						$('.table').bootstrapTable('refresh');
					}
				},
				error:function(error){
					/* alter(error); */
				}
			})
		}
		function deleteSomeCourses(){
			var list=$('.table').bootstrapTable('getSelections');
			if(list!=null){
				var idArray=new Array();
				$.each(list,function(index,value){
					idArray[index]=value.id;
				});
				var ids=idArray.join(",");
				$.ajax({

					url : "<c:url value='/courses/" + ids + "'></c:url>",

					type : 'DELETE',

					success : function(responseVO) {

						if (responseVO.errorCode == 0) {

							// 刷新表格
							$('.table').bootstrapTable('refresh');
						}
					},

					error : function(error) {

						alert(error);
					}
				});
			}
		}
		
		
		function showAddModal(){
			
			$('#model_add .form-control').val("");
			
				$('#model_add').modal('show');
			}
			function addCourses(){
				
				var name=$('#add_name').val();
				var id=$('#add_id').val();
				var describe=$('#add_describe').val();
				var subjectId=$('#add_subjectName').val();
				var createTime=$('#add_createTime').val();
				
				
				$.ajax({
					url:'<c:url value="/courses"></c:url>',
					type: 'POST',
					
					data: JSON.stringify({
						
						'id': id,
						'name': name,
						'subjectId':subjectId,
						'describe':describe,
						'createTime': createTime
						
					}),
					dataType:'json',
					contentType:'application/json',
					success:function(responseVO){
						if(responseVO.errorCode==0){
							$('#model_add').modal('hide');
							$('.table').bootstrapTable('refresh');
						}
					},
					error:function(error){
						alert(error);
					}
				});
				
			}
			
		
		
		
		$(document).ready(function() {

			$('#username').editable();

			

			$('.table').bootstrapTable({

				url : '<c:url value="/courses"></c:url>',

				columns : [ {
					checkbox : true
				}, {
					title : '标题',
					field : 'name',
					editable : {
						type : 'text',
						title : '课程标题',
						validate : function(v) {
							if (!v)
								return '课程标题不能为空';

						}
					}
				}, {
					title : '描述',
					field : 'describe',
					
				}, {
					title : '学科',
					field : 'subjectName',
					
				}, {
					title : '操作',
					formatter: function(value,row,index){
						var updateButton="<button class='btn btn-default' type='button' onclick='updateCourses("+row.id+")'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>修改</button>";
						var deleteButton="<button class='btn btn-default' type='button' onclick='deleteCourses("+row.id+")'> <span class='glyphicon glyphicon-remove' aria-hidden='true'></span>删除</button>";
						return updateButton+deleteButton;
					}
				} ],

				toolbar : '#toolbar',
				dataField : 'data',
				cache : false,
				pagination : true,
				paginationLoop : false,
				sidePagination : 'server',
				pageSize : 5,
				pageList : [ 3, 5, 10 ],

				// 启用搜索
				search : true,
				queryParams : function(params) {

					// 设置传递给服务器的数据
					// params 默认包含 offset，limit，search，sort，order

					// 新增参数 speakerId
					params['speakerId'] = $("#speaker_select").val();

					return params;
				},

				responseHandler : function(responseVO) {
					return {
						'total' : responseVO.data.count,
						'data' : responseVO.data.rows
					};
				},

				onEditableSave : function(field, row, oldValue, $el) {
					$.ajax({

						url : "<c:url value='/courses/" + row.id + "'></c:url>",
						type : 'PUT',
						
						
						contentType : 'application/json',
						data : JSON.stringify(row),

						success : function(responseVO) {

							alert("确认添加?");
						},

						error : function(error) {

							alert(JSON.stringify(error));
						},
					});
				},
			});
		});
	</script>
</body>
</html>