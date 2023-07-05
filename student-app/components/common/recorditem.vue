<template>
	<view class="container">
		<view class="record">
			<view class="content">学习内容：{{content}}</view>
			<view class="clockInDate">打卡时间：{{clockInDate}}</view>
			<view class="clockInTime">打卡时间：{{clockInTime}}</view>
		</view>
		<view class="temp"></view>

	</view>

</template>

<script>
	export default {
		props: [
			'content',
			'clockInDate',
			'clockInTime'
		],
	}
</script>

<style>
.container{
	width: 100%;
}
.temp{
	width: 100%;
	height: 80rpx;
}
.content{
	font-size: 35rpx;
}
.clockInDate{
	font-size: 35rpx;
}
.clockInTime{
	font-size: 35rpx;
}
.record{
	border: solid 1rpx #B3b3b3;
	border-radius: 20rpx;
}
</style>