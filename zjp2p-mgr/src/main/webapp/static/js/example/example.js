$(document).ready(function() {
	$('#blockTable').datagrid({
		url : ctx + '/example/template/byPage',
		toolbar : '#blockToolbar',
		pageSize : 10,
		pageList : [ 10, 20, 30 ],
		method : 'POST',
		remoteSort : true,
		columns : [ [ {
			field : 'blockNo',
			title : '分块编码',
			align : 'center',
			width : '250'
		}, {
			field : 'blockName',
			title : '分块名称',
			align : 'center',
			width : '250'
		}, {
			field : 'blockOrder',
			title : '分块序号',
			align : 'center',
			width : '100'
		}, {
			field : 'blockShow',
			title : '是否显示分块',
			align : 'center',
			width : '100',
			formatter : function(value) {
				if (value == '0') {
					return '<span>否</span>';
				} else {
					return '<span>是</span>';
				}
			}
		}, {
			field : 'blockDescription',
			title : '分块描述信息',
			align : 'center',
			width : '150'
		} ] ],
		onClickRow : function(rowIndex, rowData) {
			// 启用按钮
			$('#editBlock').linkbutton('enable');
			$('#removeBlock').linkbutton('enable');
			$('#move_up').linkbutton('enable');
			$('#move_down').linkbutton('enable');
		}
	});
	// 禁用按钮
	$('#editBlock').linkbutton('disable');
	$('#removeBlock').linkbutton('disable');
	$('#move_up').linkbutton('disable');
	$('#move_down').linkbutton('disable');
});

/*
 * 修改分块信息
 */
function editBlock(type) {
	var title = "";
	var texts = "";
	if ("add" == type) {
		title = "新增分块信息";
		texts = "添加";
		// 初始化BLOCK_NO和BLOCK_ORDER
		$.ajax({
			method : 'POST',
			url : ctx + '/shopping/block/blockList/init',
			data : {},
			success : function(data) {

			}
		});
	} else {
		title = "修改分块信息";
		texts = "修改";
		// 获取选中行的数据
		var row = $('#blockTable').datagrid('getSelected');
		if (row) {
			$('#blockNo').val(row.blockNo);
			$('#blockName').val(row.blockName);
			$('#blockOrder').val(row.blockOrder);
			if (row.blockShow == '0') {
				$("#blockShow").combobox("setValue", 0);
			} else {
				$("#blockShow").combobox("setValue", 1);
			}
			$('#blockDescription').val(row.blockDescription);
		}
	}

	// 弹出修改窗口
	$('#editBlockPanel').dialog({
		title : title,
		modal : true,
		closed : false,
		width : 350,
		height : 300,
		onBeforeOpen : function() {
			new IBankFileUpload(130);
		},
		onBeforeClose : function() {
			$('#editBlockForm').form('clear');
		},
		buttons : [ {
			text : texts,
			handler : function() {
				if (!$('#editBlockForm').form('validate')) {
					$.messager.alert('提示', '请补充必填信息！', 'error');
					return;
				}
				$.ajax({
					url : ctx + '/shopping/block/blockList/updateBlock',
					type : 'POST',
					data : {
						blockNo : $('#blockNo').val(),
						blockName : $('#blockName').val(),
						blockOrder : $('#blockOrder').val(),
						blockShow : $("#blockShow").combobox('getValue'),
						blockDescription : $("#blockDescription").val()
					},
					success : function(data) {
						$('#editBlockPanel').dialog('close');
						$('#blockTable').datagrid('reload');
						// 禁用按钮
						$('#editBlock').linkbutton('disable');
						$('#removeBlock').linkbutton('disable');
						$('#move_up').linkbutton('disable');
						$('#move_down').linkbutton('disable');
						$.messager.show({
							title : '消息',
							msg : texts + '成功！',
							timeout : 5000,
							showType : 'slide'
						});
					},
					error : function() {
						$.messager.show({
							title : '消息',
							msg : texts + '失败！',
							timeout : 5000,
							showType : 'slide'
						});
					}
				});
			}
		}, {
			text : '取消',
			handler : function() {
				$('#editBlockPanel').dialog('close');
			}
		} ]
	});
}

/*
 * 新增分块信息
 */
function addBlock() {
	// 弹出新增窗口
	$('#addBlockPanel').dialog({
		title : '新增分块信息',
		modal : true,
		closed : false,
		width : 450,
		height : 400,
		onBeforeClose : function() {
			$('#addBlockForm').form('clear');
		},
		buttons : [ {
			text : '添加',
			handler : function() {
				if (!$('#addBlockForm').form('validate')) {
					$.messager.alert('提示', '请补充必填信息！', 'error');
					return;
				}
				$.ajax({
					url : ctx + '/shopping/block/blockList/addBlock',
					type : 'POST',
					data : {
						blockNo : $('#block_No').val(),
						blockName : $('#block_Name').val(),
						blockOrder : $('#block_Order').val(),
						blockShow : $("#block_Show").combobox('getValue'),
						blockDescription : $("#block_Description").val()
					},
					success : function(data) {
						$('#addBlockPanel').dialog('close');
						$('#blockTable').datagrid('reload');
						$.messager.show({
							title : '消息',
							msg : '添加成功！',
							timeout : 5000,
							showType : 'slide'
						});
					},
					error : function() {
						$.messager.show({
							title : '消息',
							msg : '添加失败！',
							timeout : 5000,
							showType : 'slide'
						});
					}
				});
			}
		}, {
			text : '取消',
			handler : function() {
				$('#addBlockPanel').dialog('close');
			}
		} ]
	});
}

/*
 * 删除分块
 */
function removeBlock() {
	// 获取选中行的数据
	var row = $('#blockTable').datagrid('getSelected');
	if (row) {
		var blockNo = row.blockNo;

		var content = '确认删除[' + row.blockName + ']分块吗?';

		$.messager.defaults = {
			ok : "确认",
			cancel : "取消"
		};

		$.messager.confirm('确认删除', content, function(r) {
			if (r) {
				$.ajax({
					url : ctx + '/shopping/block/blockList/deleteBlock',
					type : 'POST',
					data : {
						blockNo : blockNo
					},
					success : function(data) {
						$('#blockTable').datagrid('reload');
						// 禁用按钮
						$('#editBlock').linkbutton('disable');
						$('#removeBlock').linkbutton('disable');
						$('#move_up').linkbutton('disable');
						$('#move_down').linkbutton('disable');
						$.messager.show({
							title : '消息',
							msg : '删除成功！',
							timeout : 5000,
							showType : 'slide'
						});
					},
					error : function() {
						$.messager.show({
							title : '消息',
							msg : '删除失败！',
							timeout : 5000,
							showType : 'slide'
						});
					}
				});
			}
		});
	}
}

/*
 * 上移
 */
function upMove() {
	// 获取选中行
	var row = $('#blockTable').datagrid('getSelected');
	// 获取选中行的上一行
	if (row) {
		$.ajax({
			url : ctx + '/shopping/block/blockList/getMinBlockOrder',
			type : 'POST',
			success : function(data) {
				if (parseInt(data.result.blockOrder, 10) < parseInt(row.blockOrder, 10)) {
					var blockNo = row.blockNo;
					var blockOrder = row.blockOrder;
					$.ajax({
						url : ctx + '/shopping/block/blockList/upAndDown',
						type : 'POST',
						data : {
							blockNo : blockNo,
							blockOrder : blockOrder,
							type : 'up'
						},
						success : function(data) {
							$('#blockTable').datagrid('reload');
							// 禁用按钮
							$('#editBlock').linkbutton('disable');
							$('#removeBlock').linkbutton('disable');
							$('#move_up').linkbutton('disable');
							$('#move_down').linkbutton('disable');
						}
					});
				} else {
					$.messager.defaults = {
						ok : "确定"
					};
					$.messager.alert("提示", "已置顶,请确认!", "info");
				}
			}
		});
	}
}

/*
 * 下移
 */
function downMove() {
	// 获取选中行
	var row = $('#blockTable').datagrid('getSelected');
	// 获取选中行的下一行
	if (row) {
		$.ajax({
			url : ctx + '/shopping/block/blockList/getMaxBlockOrder',
			type : 'POST',
			success : function(data) {
				if (parseInt(data.result.blockOrder, 10) > parseInt(row.blockOrder, 10)) {
					var blockNo = row.blockNo;
					var blockOrder = row.blockOrder;
					$.ajax({
						url : ctx + '/shopping/block/blockList/upAndDown',
						type : 'POST',
						data : {
							blockNo : blockNo,
							blockOrder : blockOrder,
							type : 'down'
						},
						success : function(data) {
							$('#blockTable').datagrid('reload');
							// 禁用按钮
							$('#editBlock').linkbutton('disable');
							$('#removeBlock').linkbutton('disable');
							$('#move_up').linkbutton('disable');
							$('#move_down').linkbutton('disable');
						}
					});
				} else {
					$.messager.defaults = {
						ok : "确定"
					};
					$.messager.alert("提示", "已是最后,请确认!", "info");
				}
			}
		});
	}
}
/**
 * 文件上传回调
 */
function fileUploadCallback(fileId, fileDesc, fileName, fileNail) {
	alert("文件名：" + $("#" + fileId).attr("fileName") + " 状态：" + $("#" + fileId).attr("status"));
}