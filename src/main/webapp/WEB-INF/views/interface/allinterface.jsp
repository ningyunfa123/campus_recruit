<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta charset="utf-8"/>
<meta name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>

<%-- <link type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap-pagination.min.css"
	rel="stylesheet" /> --%>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/js/bootstrap-paginator.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/js/bootstrap-paginator.min.js"></script>
<%HttpSession httpSession = request.getSession();%>
<%String productId= (String) httpSession.getAttribute("productId");%>
<div class="row search">
    <div class="col-md-6">
        <form action="" method="post">
            <div class="input-group" style="width: 300px">
                <input type="text" class="form-control" id="queryName"
                       placeholder="请输入接口名称..."> <span class="input-group-btn">
					<button class="btn btn-default" onclick="return queryEquipment()">
						<span class="glyphicon glyphicon-search"></span>&nbsp;查询
					</button>
				</span>
            </div>
        </form>
    </div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary" style="float: left;"
                data-toggle="modal" data-target="#createEquipment" >添加</button>
    </div>
    <div class="col-md-4">

    </div>

</div>
<!--
<div class="row search">
    <button type="button" class="btn btn-primary" style="float: right;"
            data-toggle="modal" data-target="#createEquipment" >添加</button>
</div>
-->
<p><font face="verdana">下列是所有接口信息：</font></p>

<div>
    <table class="table table-hover  table-bordered table-striped"
           style="margin-bottom: 0px;">
        <thead>
        <tr>
            <th class="col-md-1">序号</th>
            <th class="col-md-2">接口名称</th>
            <th class="col-md-1">请求方式</th>
            <th class="col-md-1">所属模块</th>
            <th class="col-md-2">操作</th>
        </tr>
        </thead>
        <tbody id="equList"></tbody>
    </table>
</div>
<div id="pagination">
    <div class="col-md-5 col-md-offset-3">
        <ul class="pagination"></ul>
    </div>
    <div class="btn-group col-md-3" style="margin-top:20px">
        <button type="button" class="btn btn-default" value="10" onclick="changePageSize(this)">10</button>
        <button type="button" class="btn btn-default" value="20" onclick="changePageSize(this)">20</button>
        <button type="button" class="btn btn-default" value="50" onclick="changePageSize(this)">50</button>
        <button type="button" class="btn btn-default" value="100" onclick="changePageSize(this)">100</button>
    </div>
    <input type="text" id="currentPage" style="display:none" value="1"></input>
    <input type="text" id="pageSize" style="display:none" value="10"></input>
</div>

<!-- 更新模态框 -->
<form method="post" class="form-horizontal" action="" role="form"
      id="updateForm" style="margin: 20px;">
    <div class="modal fade" id="updateEquipment" tabindex="-1"
         role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true"
         data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <input type="text" name="equipmentId" id="upInterfaceId"
                       style="display:none"/>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title" id="updateModalLabel">信息修改</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="upName" class="col-md-4 control-label">接口名称</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="upName" name="name"
                                   placeholder="公司名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upInterfacePath" class="col-md-4 control-label">接口路径</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="upInterfacePath" name="name"
                                   placeholder="公司名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upInterfaceParam" class="col-md-4 control-label">接口参数</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="upInterfaceParam" name="name"
                                   placeholder="接口参数，逗号隔开">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="upRequestsType" class="col-md-4 control-label">请求方式</label>
                        <div class="col-md-6">
                            <select id="upRequestsType" class="form-control" name="requestsType">
                                <option value="POST">POST</option>
                                <option value="GET">GET</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upResponseExa" class="col-md-4 control-label">接口返回示例</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="no" id="upResponseExa"
                                   placeholder="请输入投递链接">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upRequestExa" class="col-md-4 control-label">接口请求示例</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="no" id="upRequestExa"
                                   placeholder="请输入投递链接">
                        </div>
                    </div>
                </div>


                <div class="modal-footer" style="text-align:center">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                    </button>
                    <button type="submit" class="btn btn-primary">修改</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>
</form>


<!-- 添加模态框 -->

<form method="post" class="form-horizontal" action="" role="form"
      id="createForm" style="margin: 20px;">
    <div class="modal fade" id="createEquipment" tabindex="-1"
         role="dialog" aria-labelledby="createModalLabel" aria-hidden="true"
         data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title" id="crdateModalLabel">添加设备</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="crName" class="col-md-4 control-label">接口名称</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="crName" name="name"
                                   placeholder="请输入接口名称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="crInterfacePath" class="col-md-4 control-label">接口路径</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="produceName"
                                   value="" id="crInterfacePath" placeholder="请输入接口路径">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="crInterfaceParam" class="col-md-4 control-label">请求参数</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="crInterfaceParam" id="crInterfaceParam"
                                   placeholder="请输入请求参数，用逗号隔开">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="crInterfaceResponse" class="col-md-4 control-label">接口返回示例</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="crInterfaceResponse" id="crInterfaceResponse"
                                   placeholder="请输入接口返回示例，json格式">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="crRequestsType" class="col-md-4 control-label">请求方式</label>
                        <div class="col-md-6">
                            <select id="crRequestsType" class="form-control" name="crRequestsType">
                                <option value="POST">POST</option>
                                <option value="GET">GET</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="crParamExam" class="col-md-4 control-label">参数请求示例</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="crParamExam" id="crParamExam"
                                   placeholder="接口参数请求示例，json格式">
                        </div>
                    </div>

                </div>
                <div class="modal-footer" style="text-align:center">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">添加</button>
                </div>
            </div>

        </div>

    </div>
</form>



<form name="template">
    <input type="hidden" name="productId" id="productId" value="<%=productId%>">
</form>




<script type="text/javascript">
    $(function () {
        pagehtml($("#currentPage").val());

    });


    $('#datetimepicker').datetimepicker({
        format: 'MM/dd/yyyy',
        language: 'en',
        pickDate: true,
        pickTime: false,
        hourStep: 1,
        minuteStep: 15,
        secondStep: 30,
        inputMask: true,
        startDate: new Date()
    });


    //获取要修改的设备
    function getEquipmentById(interfaceId) {

        if (!interfaceId) {
            alert('接口id获取为空！');
            return false;
        }
        $
            .ajax({
                url: "${pageContext.request.contextPath}/interface/queryinterfacebyid",
                data: {
                    interfaceId: interfaceId
                },
                type: "get",
                success: function (data) {
                    $("#upName").val(data.interfacename);
                    $("#upRequestsType").val(data.requeststype);
                    $("#upResponseExa").val(data.interfaceresponse);
                    $("#upRequestExa").val(data.paramexam);
                    $("#upInterfaceId").val(data.id);
                    $("#upInterfacePath").val(data.interfacepath);
                    $("#upInterfaceParam").val(data.interfaceparam)
                },
                error: function () {
                    alert("请求出错");
                },
            });
        return false;
    }
    //修改设备
    $("#updateForm")
        .submit(
            function (e) {
                var interfaceName = $.trim($("#upName").val());
                var paramExam = $.trim($("#upRequestExa").val());
                var interfaceResponse = $.trim($("#upResponseExa").val());
                var requestsType = $.trim($("#upRequestsType").val());
                var interfacePath = $.trim($("#upInterfacePath").val());
                var interfaceParam = $.trim($("#upInterfaceParam").val());
                $
                    .ajax({
                        url: "${pageContext.request.contextPath}/interface/updateinterface",
                        type: "post",
                        contentType: "application/json",
                        data: JSON.stringify({
                            interfaceName: interfaceName,
                            paramExam: paramExam,
                            interfaceResponse: interfaceResponse,
                            id: $("#upInterfaceId").val(),
                            requestsType: requestsType,
                            interfacePath:interfacePath,
                            interfaceParam:interfaceParam
                        }),
                        success: function (data) {
                            if (data.errno == 0) {
                                alert("修改成功!");
                                pagehtml($("#currentPage").val());
                            } else {
                                alert(data.msg);
                            }

                        },
                        error: function () {
                            alert("修改出错!");
                        }

                    });
                e.preventDefault();
            });

    //添加设备
    $("#createForm")
        .submit(
            function (e) {
                var interfaceName = $.trim($("#crName").val());
                var interfacePath = $.trim($("#crInterfacePath").val());
                var interfaceParam = $.trim($("#crInterfaceParam").val());
                var requestsType = $.trim($("#crRequestsType").val());
                var interfaceResponse = $.trim($("#crInterfaceResponse").val());
                var paramExam = $.trim($("#crParamExam").val());
                var productId = $.trim($("#productId").val());

                if (!interfaceName) {
                    alert("接口名不为空！");
                    return false;
                }
                if(!productId){
                    alert("productId不为空");
                    return false;
                }

                $
                    .ajax({
                        url: "${pageContext.request.contextPath}/interface/addinterface",
                        type: "post",
                        contentType: "application/json",
                        data: JSON.stringify({
                            interfaceName: interfaceName,
                            interfacePath: interfacePath,
                            interfaceParam: interfaceParam,
                            requestsType: requestsType,
                            interfaceResponse:interfaceResponse,
                            paramExam:paramExam,
                            productId:productId
                        }),
                        success: function (data) {
                            if (data.errno == 0) {
                               <!-- $("#createEquipment").modal('hide');-->

                                alert("添加成功!");
                                pagehtml($("#currentPage").val());
                            } else {
                                alert(data.msg);
                            }

                        },
                        error: function () {
                            alert("添加出错!");
                        }

                    });
                e.preventDefault();
            });

    //分页
    function pagehtml(pageNo) {
        var productId = $.trim($("#productId").val());
        var interfaceName = $.trim($("#queryName").val());
        $
            .ajax({
                url: "${pageContext.request.contextPath}/interface/queryinterfacebyproductid",
                type: "post",
                data: {
                    pageNo: pageNo,
                    pageSize: $("#pageSize").val(),
                    productId:productId,
                    interfaceName:interfaceName
                },
                success: function (data) {
                    var options = {
                        alignment: "center",//居中显示
                        currentPage: data.page.pageNo,//当前页数
                        totalPages: data.page.totalPages,//总页数
                        bootstrapMajorVersion: 3,
                        onPageClicked: function (event, originalEvent,
                                                 type, page) {
                            $("#currentPage").val(page);
                            pagehtml(page);
                        }
                    };
                    $("#equList").empty();
                    if (data.data == "") {
                        $("#equList").html("<div  id='emptyAlert' class='alert alert-danger'>" +
                            "<a href='#' class='close' data-dismiss='alert'>&times;</a>" +
                            "<strong>失败！</strong>未找到任何接口</div>");
                        $("#pagination").hide();
                        return false;
                    } else {

                        $
                            .each(
                                data.data,
                                function (j, val) {
                                    var html;
                                    html = "<tr>"
                                        + "<td>"
                                        + ((data.page.pageNo - 1)
                                            * data.page.pageSize
                                            + j + 1)
                                        + "</td>"
                                        + "<td>"
                                        + val.interfacename
                                        + "</td>"
                                        + "<td>"
                                        + val.requeststype
                                        + "</td>"
                                        + "<td>"
                                        + val.status
                                        + "</td>"
                                        +"<td><button type='button' class='btn btn-info btn-xs' onclick='return getEquipmentById("
                                        + val.id
                                        +")' data-toggle='modal' data-target='#updateEquipment'>修改</button></td>"
                                        +"</tr>";
                                    $("#equList").append(html);

                                });
                        $("#pagination").show();
                        $(".pagination").bootstrapPaginator(options);
                    }

                },
                error: function (error) {
                    alert("error");
                }
            });
    }

    function goVisit(dest) {
        //       window.open(dest);
//        location.href = "http://www.baidu.com";
//        alert(dest);
    }
    //查询设备
    function queryEquipment() {
        //不管name是否为空，使得搜索条件为空时，查询所有
        pagehtml(1);
        return false;
    }


    //切换每页显示数据数
    function changePageSize(obj) {
        var pageSize = obj.value;
        $("#pageSize").val(pageSize);
        pagehtml(1);
    }

    // 设置为已经投递
    function  apply(equipmentId) {
        var result = confirm("确定置为已投？");
        if (result) {

        } else {
            return false;
        }
        $
            .ajax({
                url: "${pageContext.request.contextPath}/equipment/apply/"+ equipmentId,
                data: {
                    "equipmentId": equipmentId
                },
                type: "get",
                success: function (data) {
                    if (data == true) {
                        alert("设置成功！");
                        pagehtml($("#currentPage").val());
                    } else {
                        alert("设置失败！");
                    }
                },
                error: function () {
                    alert("设置错误");
                },
            });
        return false;
    }
</script>


</html>
