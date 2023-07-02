<template>
	<view class="container">
		<view class="ranking">{{ranking+1}}</view>
		<view class="accountId">{{accountId}}</view>
		<view class="nickName">{{nickName}}</view>
		<view class="totaltime">{{totaltime}}</view>
	</view>

</template>

<script>
	export default {
		props: [
			'ranking',
			'accountId',
			'nickName',
			'totaltime'
		],
	}
</script>

<style>
	.container{
	display: flex;
	width: 750rpx;
	height: 100rpx;
	align-items: center;
	}
	.ranking{
		display: flex;
		width: 10%;
		justify-content: center;
		align-items: center;
		margin-left: 45rpx;
	}
	.accountId{
		display: flex;
		width: 20%;
		justify-content: center;
		align-items: center;
		margin-left: 55rpx;
	}
	.nickName{
		display: flex;
		width: 20%;
		justify-content: center;
		align-items: center;
		margin-left: 20rpx;
	}
	.totaltime{
		display: flex;
		width: 20%;
		justify-content: center;
		align-items: center;
		margin-left: 50rpx;
	}

</style>