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


<div>
    <table class="table table-hover  table-bordered table-striped"
           style="margin-bottom: 0px;">
        <thead>
        <tr>
            <th class="col-md-1">序号</th>
            <th class="col-md-1">日志id</th>
            <th class="col-md-1">日志类型</th>
            <th class="col-md-1">日志展示</th>
        </tr>
        </thead>
        <tbody id="equList"></tbody>
        <tr>
            <td> <button type="button" class="btn btn-default" value="10" onclick="changePageSize(this)">10</button></td>
        </tr>
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

    //分页
    function pagehtml(pageNo) {
        $
            .ajax({
                url: "${pageContext.request.contextPath}/interface/queryallinterface",
                type: "post",
                data: {
                    pageNo: pageNo,
                    pageSize: $("#pageSize").val()
                },
                success: function (data) {
                    $("#total").html("当前共有" + data.page.totalElements + "家公司");
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
                            "<strong>失败！</strong>未查到您搜索的信息。</div>");
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
                                        +"<td>"
                                        + val.productid
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



    //切换每页显示数据数
    function changePageSize(obj) {
        var pageSize = obj.value;
        $("#pageSize").val(pageSize);
        pagehtml(1);
    }

    // 设置为已经投递
    function  addToMe(equipmentId) {
        var result = confirm("确定执行此操作？");
        if (result) {

        } else {
            return false;
        }
        $
            .ajax({
                url: "${pageContext.request.contextPath}/equipment/addToMe/"+ equipmentId,
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
