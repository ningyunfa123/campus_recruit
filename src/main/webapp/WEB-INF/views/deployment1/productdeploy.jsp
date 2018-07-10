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
                <label for="auditStatus" class="col-md-4 control-label glyphicon">申请状态</label>
                <select id="auditStatus" class="form-control glyphicon" name="auditStatus">
                    <option value="0">申请中</option>
                    <option value="1">申请成功</option>
                    <option value="2">申请拒绝</option>
                </select>
                <label for="auditTime" class="col-md-4 control-label glyphicon">申请时间</label>
                <select id="auditTime" class="form-control glyphicon" name="auditStatus">
                    <option value="30">一个月内</option>
                    <option value="90">三个月内</option>
                    <option value="180">半年内</option>
                    <option value="365">一年内</option>
                </select>
                <button class="btn btn-default" onclick="return queryEquipment()">
                    <span class="glyphicon glyphicon-search"></span>&nbsp;查询
                </button>
                </span>
            </div>
        </form>

    </div>
    <div class="col-md-2">
        <button type="button" class="btn btn-primary" style="float: left;"
                data-toggle="modal" data-target="#createEquipment" >模块部署</button>
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
            <th class="col-md-2">模块名称</th>
            <th class="col-md-1">权限类型</th>
            <th class="col-md-1">申请时间</th>
            <th class="col-md-2">当前状态</th>
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
                    <h4 class="modal-title" id="crdateModalLabel">模块部署</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="productName" class="col-md-4 control-label">模块名</label>
                        <div class="col-md-6">
                            <select id="productName" class="form-control" name="productName" onchange="enableSelectPipe()">
                                <option value="-1">请选择</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="pipeLine" class="col-md-4 control-label">管道类型</label>
                        <div class="col-md-6">
                            <select id="pipeLine" class="form-control" name="type"  disabled="" onchange="getAllBranch()">
                                <option value="-1">请选择</option>
                                <option value="BranchPipeline">BranchPipeline</option>
                                <option value="ChangePipeline">ChangePipeline</option>
                                <option value="MasterPipeline">MasterPipeline</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="branch" class="col-md-4 control-label">部署分支</label>
                        <div class="col-md-6">
                            <select id="branch" class="form-control" name="applyTime" disabled="">
                                <option value="-1">请选择</option>
                            </select>
                        </div>
                    </div>

                </div>
                <div class="modal-footer" style="text-align:center">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
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
        getAllproduct();

    });

    function enableSelectPipe() {
        var productName = $.trim($("#productName").val());
        if(productName !="-1"){
            $("#pipeLine").attr("disabled",false);
        }else{
            $("#pipeLine").attr("disabled",true);
            var value = "-1";
            $("#pipeLine").val(value);
        }
    }
    function getAllBranch() {
        var pipeLineName = $.trim($("#pipeLine").val());
        var productName = $.trim($("#productName").val());
        if(pipeLineName != "-1"){
            $("#branch").attr("disabled",false);
            getBranch(productName,pipeLineName);
        }else{
            $("#branch").attr("disabled",true);
        }
    }
    function getBranch(productName,pipeLineName) {
        if(productName == "-1" || pipeLineName == "-1" || productName == "" || pipeLineName == ""){
            alert("参数有误");
            return false;
        }
        $
            .ajax({
                url: "${pageContext.request.contextPath}/productline/getbranchinfo",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify({
                    productName:productName,
                    pipeLineName:pipeLineName
                }),
                success: function (data) {
                    if(data.errno != 0){
                        alert(data.msg);
                    }else{
                        $
                            .each(
                                data.data,
                                function (j, val) {
                                    var html;

                                    html = "<option value='"+val.branchName+"'>"+val.branchName+"</option>";
                                    $("#branch").append(html);

                                });
                    }







                },
                error: function (error) {
                    alert("页面出错");
                }
            });
    }
    function getAllproduct(){
        $
            .ajax({
                url: "${pageContext.request.contextPath}/productline/queryproductbyuseridandauditstatus",
                type: "get",
                data:{
                    auditStatus:1
                },
                dataType : "json",
                success: function (data) {



                    $
                        .each(
                            data.data,
                            function (j, val) {
                                var html;

                                html = "<option value='"+val.productname+"'>"+val.productname+"</option>";
                                $("#productName").append(html);

                            });



                },
                error: function (error) {
                    alert("页面出错");
                }
            });
    }

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


    //添加设备
    $("#createForm")
        .submit(
            function (e) {
                var productName = $.trim($("#productName").val());
                var pipeLineName = $.trim($("#pipeLine").val());
                var branch = $.trim($("#branch").val());
                if (!productName) {
                    alert("接口名不为空！");
                    return false;
                }
                if(!pipeLineName){
                    alert("productId不为空");
                    return false;
                }
                if(!branch){
                    alert("branch不为空");
                    return false;
                }

                $
                    .ajax({
                        url: "${pageContext.request.contextPath}/productline/deploy",
                        type: "post",
                        contentType: "application/json",
                        data: JSON.stringify({
                            productName: productName,
                            pipeLineName: pipeLineName,
                            branch: branch
                        }),
                        success: function (data) {
                            if (data.errno == 0) {
                                <!-- $("#createEquipment").modal('hide');-->

                                alert("部署成功!");
                                //pagehtml($("#currentPage").val());
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
                url: "${pageContext.request.contextPath}/productline/queryrecord",
                type: "post",
                data: {
                    pageNo: pageNo,
                    pageSize: $("#pageSize").val(),
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
                                    var status;
                                    if(val.auditstatus ==0){
                                        status="申请中";
                                    }else if(val.auditstatus ==1){
                                        status="申请成功";
                                    }else if(val.auditstatus ==2){
                                        status="申请退回";
                                    }else{
                                        status="状态出错";
                                    }
                                    var html;
                                    html = "<tr>"
                                        + "<td>"
                                        + ((data.page.pageNo - 1)
                                            * data.page.pageSize
                                            + j + 1)
                                        + "</td>"
                                        + "<td>"
                                        + val.productname
                                        + "</td>"
                                        + "<td>"
                                        + val.type
                                        + "</td>"
                                        + "<td>"
                                        + val.updatetime
                                        + "</td>"
                                        +"<td>"
                                        +status
                                        +"</td>"
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
