<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table id="dTable" class="table table-bordered table-hover definewidth m10">
<p id="detailShow"><span>明细单</span></p>
<tr>
	<td>编号</td>
	<td>商品编号</td>
	<td>商品数量</td>
	<td>商品单价</td>
	<td>折扣</td>
</tr>
<c:forEach items="${saleDetail }" var="sd" varStatus="sdStatus">
	<tr>
		<td>${sdStatus.index }</td>
		<td>${sd.goodsId }</td>
		<td>${sd.number }</td>
		<td>${sd.price }</td>
		<td>${sd.goodsDiscount }</td>
	</tr>
</c:forEach>
</table>
<script type="text/javascript">
	$("#detailShow").click(function(){
		$('#detail').empty();
	});

</script>