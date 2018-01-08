<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频管理</title>

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
					<a href="#"> 首页 </a>
				</li>
				<li  class="active">
					<a href='<c:url value="/video"></c:url>'> 视频管理 </a>
				</li>
				<li>
					<a href='<c:url value="/speaker"></c:url>'>讲师管理</a>
				</li>
				<li>
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
			<div class="panel-heading">视频管理</div>
			<div class="btn-group" role="group" aria-label="...">
					<button type="button" class="btn btn-default" id="video_add" onclick="showAddModal()">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					添加</button>
					<button type="button" class="btn btn-default" onclick="deleteSomevideos()">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					删除</button>

			</div>
			<div id="toolbar">
				<select id="speaker_select">
					<option value="0">全部讲师</option>
					<c:forEach items="${speakers}" var="speaker">
						<option value="${speaker.id }">${speaker.name }</option>
					</c:forEach>
				</select>
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
					<h4 class="modal-title" id="exampleModalLabel">更新视频</h4>
				</div>
				<div class="modal-body">
					<form>
						<input type="hidden" class="form-control" id="update_id">
						<div class="form-group">
							<label for="recipient-name" class="control-label">标题:</label>
							<input type="text" class="form-control" id="update_name">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">课程:</label>
							<select id="update_course">
							
							<c:forEach items="${courses}" var="course">
								<option value="${course.id }">${course.name }</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">学科:</label>
							<select id="update_subject">
							
							<c:forEach items="${subjects}" var="subject">
								<option value="${subject.id }">${subject.name }</option>
							</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">讲师:</label>
							<select id="update_speaker">
							
							<c:forEach items="${speakers}" var="speaker">
								<option value="${speaker.id }">${speaker.name }</option>
							</c:forEach>
							</select>
						</div>
						
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="showUpdateVideos()">更新</button>
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
					<h4 class="modal-title" id="exampleModalLabel">添加视频</h4>
				</div>
				<div class="modal-body">
					<form>
						<input type="hidden" class="form-control" id="update_id">
						<div class="form-group">
							<label for="recipient-name" class="control-label">标题:</label>
							<input type="text" class="form-control" id="add_name">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">课程:</label>
							<select id="add_course">
							
							<c:forEach items="${courses}" var="course">
								<option value="${course.id }">${course.name }</option>
							</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">讲师:</label>
							<select id="add_speaker">
							
							<c:forEach items="${speakers}" var="speaker">
								<option value="${speaker.id }">${speaker.name }</option>
							</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="recipient-name" class="control-label">描述:</label>
							<input type="text" class="form-control" id="add_describe">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">播放次数:</label>
							<input type="number" class="form-control" id="add_playCount">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">视频长度:</label>
							<input type="number" class="form-control" id="add_length">
						</div>
						
						
						
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" onclick="addVideos()">添加</button>
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
	function updateVideos(id){
		$.ajax({
			url:"<c:url value='/video/"+id+"'></c:url>",
			success: function(responseVO){
				if(responseVO.errorCode==0){
					
					
					$('#update_name').val(responseVO.data.name); 
					$('#update_subject').val(responseVO.data.subject.name);
					$('#update_speaker').val(responseVO.data.speaker.name); 
					/* $('#update_course').val(responseVO.data.course.name);  */
					
					$('#update_id').val(responseVO.data.id); 
					
					$('#model_update').modal('show');
					
				}
			},
			error:function(){
				
			}
		});
		
	}
		function showUpdateVideos(){
			
			var courseId=$('#update_course').val();
			var subjectId=$('#update_subject').val();
			var speakerId=$('#update_speaker').val();
			var id=$('#update_id').val();
			
			//alert(name+courseName+subjectName+speakerName+id);
			
			$.ajax({
				url:"<c:url value='/videos'></c:url>",
				type: 'PUT',
				data: JSON.stringify({
					'id': id,
					'courseId': courseId,
					'subjectId': subjectId,
					'speakerId': speakerId
					
					
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
		
		function deleteVideos(id){
			$.ajax({
				url: "<c:url value='/videos/" + id + "'></c:url>",
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
		function deleteSomevideos(){
			var list=$('.table').bootstrapTable('getSelections');
			if(list!=null){
				var idArray=new Array();
				$.each(list,function(index,value){
					idArray[index]=value.id;
				});
				var ids=idArray.join(",");
				$.ajax({

					url : "<c:url value='/videos/" + ids + "'></c:url>",

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
			function addVideos(){
				
				var name=$('#add_name').val();
				var courseId=$('#add_course').val();
				var speakerId=$('#add_speaker').val();
				var describe=$('#add_describe').val();
				var playCount=$('#add_playCount').val();
				var length=$('#add_length').val();
				
				$.ajax({
					url:'<c:url value="/videos"></c:url>',
					type: 'POST',
					
					data: JSON.stringify({
						
						'name':name,
						'courseId':courseId,
						'speakerId': speakerId,
						'describe': describe,
						'playCount':playCount,
						'length':length
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

			$('#speaker_select').change(function() {

				// 选择讲师后，自动刷新 table
				$('.table').bootstrapTable('refresh');
			})

			$('.table').bootstrapTable({

				url : '<c:url value="/videos"></c:url>',

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
					title : '课程',
					field : 'course.name',
					
				}, {
					title : '学科',
					field : 'subject.name',
					
				}, {
					title : '讲师',
					field : 'speaker.name',
					
				}, {
					title : '时长',
					field : 'length',
					sortable:true
				}, {
					title : '播放次数',
					field : 'playCount',
					sortable:true
				}, {
					title : '操作',
					formatter: function(value,row,index){
						var updateButton="<button class='btn btn-default' type='button' onclick='updateVideos("+row.id+")'> <span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>修改</button>";
						var deleteButton="<button class='btn btn-default' type='button' onclick='deleteVideos("+row.id+")'> <span class='glyphicon glyphicon-remove' aria-hidden='true'></span>删除</button>";
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

						url : "<c:url value='/videos/" + row.id + "'></c:url>",
						type : 'PUT',
						
						// 415 是 contentType 没有设置对
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