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

<title>添加展示日志</title>

<script type="text/javascript">


    function createConfig(){
        var productId = $.trim($("#productId").val());
        var interfaceName = $.trim($("#interfaceName").val());
        var interfacePath = $.trim($("#interfacePath").val());
        var interfaceParam = $.trim($("#interfaceParam").val());
        var interfaceResponse = $.trim($("#interfaceResponse").val());
        var requestsType = $.trim($("#requestsType").val());
        var requestParam = {
            productId:productId,
            interfaceName:interfaceName,
            interfacePath:interfacePath,
            interfaceParam:interfaceParam,
            interfaceResponse:interfaceResponse,
            requestsType:requestsType
        }
        $
            .ajax({
                url: "${pageContext.request.contextPath}/interface/addinterface",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify(requestParam),
                success: function (data) {
                    if (data.errno == 0) {
                        alert("添加成功!");
                        pagehtml($("#currentPage").val());
                    }else{
                        alert(data.msg);
                    }
                },
                error: function () {
                    alert("添加出错!");
                }
            });
    }
</script>

<form method="post" class="form-horizontal" action="" role="form"
      id="createForm" style="margin: 20px;">
    <div class="modal fade" id="createEquipment" tabindex="-1"
         role="dialog" aria-labelledby="createModalLabel" aria-hidden="true"
         data-backdrop="static">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="productId" class="col-md-4 control-label">产品id</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="productId" name="productId"
                                   placeholder="">
                        </div>
                        <label for="interfaceName" class="col-md-4 control-label">接口名</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="interfaceName" name="interfaceName"
                                   placeholder="">
                        </div>
                        <label for="interfacePath" class="col-md-4 control-label">接口路径</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="interfacePath" name="interfacePath"
                                   placeholder="">
                        </div>
                        <label for="interfaceParam" class="col-md-4 control-label">请求参数</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="interfaceParam" name="interfaceParam"
                                   placeholder="">
                        </div>
                        <label for="interfaceResponse" class="col-md-4 control-label">请求返回</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="interfaceResponse" name="interfaceResponse"
                                   placeholder="">
                        </div>
                        <label for="requestsType" class="col-md-4 control-label">请求类型</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="requestsType" name="requestsType"
                                   placeholder="">
                        </div>
                    </div>

                </div>
                <div class="modal-footer" style="text-align:center">
                    <button id="saveConfig" type="button" class="btn btn-primary" onclick="createConfig()" >提交</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>

</form>


