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

<title>配置提交</title>

<script type="text/javascript">

    $(document).ready(function () {
        $("#showAnother").click(function () {
            var tb = document.getElementById("needToOp");
            if(tb.style.display=='none') tb.style.display='block';
        })
        $("#hideAnother").click(function () {
            var tb1 = document.getElementById("needToOp");
            if(tb1.style.display=='block') tb1.style.display='none';
        })
    })

    function createConfig(){
        var tb = document.getElementById("needToOp");
        var uriConfig = $.trim($("#uriConfig").val());
        var keyWordForReq = $.trim($("#keyWordForReq").val());
        var keyWordForResp = $.trim($("#keyWordForResp").val());
        var tagWordForReq = $.trim($("#tagWordForReq").val());
        var tagWordForResp = $.trim($("#tagWordForResp").val());
        var extraParams = $.trim($("#extra").val());
        var fileName = $.trim($("#fileName").val());
        if(tb.style.display=='none'){
            extraParams="";
        }
        $
            .ajax({
                url: "${pageContext.request.contextPath}/config/saveConfig",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify({
                    uriConfig:uriConfig,
                    keyWordForReq:keyWordForReq,
                    keyWordForResp:keyWordForResp,
                    tagWordForReq:tagWordForReq,
                    tagWordForResp:tagWordForResp,
                    extraParams:extraParams,
                    fileName:fileName
                }),
                success: function (data) {
                    if (data == true) {
                        alert("添加成功!");
                        pagehtml($("#currentPage").val());
                    }else{
                        alert("添加失败");
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
                        <label for="uriConfig" class="col-md-4 control-label">URI</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="uriConfig" name="uriConfig"
                                   placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="keyWordForReq" class="col-md-4 control-label">keyWordForReq</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="keyWordForReq"
                                   value="" id="keyWordForReq" placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="keyWordForResp" class="col-md-4 control-label">keyWordForResp</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="tagWordForReq" id="keyWordForResp"
                                   placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tagWordForReq" class="col-md-4 control-label">tagWordForReq</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="tagWordForReq" id="tagWordForReq"
                                   placeholder="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tagWordForResp" class="col-md-4 control-label">tagWordForResp</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="tagWordForResp" id="tagWordForResp"
                                   placeholder="">
                        </div>
                    </div>
                    <div id="needToOp" style="display: none" class="form-group">
                        <label for="extra" class="col-md-4 control-label">extraParams</label>
                        <div class="col-md-6">
                            <input type="text"  class="form-control" name="extraParams" id="extra"
                                   placeholder="多个参数用逗号隔开">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="fileName" class="col-md-4 control-label">文件名</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" name="tagWordForResp" id="fileName"
                                   placeholder="默认系统创建名">
                        </div>
                    </div>

                </div>
                <div class="modal-footer" style="text-align:center">
                    <button id="showAnother" type="button" class="btn btn-default" >添加</button>
                    <button id="hideAnother" type="button" class="btn btn-primary">删除</button>
                    <button id="saveConfig" type="button" class="btn btn-primary" onclick="createConfig()" >提交</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal -->
    </div>

</form>


