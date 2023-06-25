<template>
	<view class="container">
		<view class="temp1"></view>
		<view class="study-content">
			<view class="temp2"></view>
			<view class="content-text">
				<text style="font-size: 40rpx;">本次学习内容:</text>
			</view>
			<view class="temp3"></view>
			<view class="content-checkbox">

			</view>
			<view class="temp4"></view>
		</view>
		<view class="temp5"></view>
		<view class="time-content">
			<view class="temp2"></view>
			<view class="time-text">
				<text style="font-size: 40rpx;">本次学习内容:</text>
			</view>
			<view class="temp3"></view>
			<view class="time-checkbox">

			</view>
			<view class="temp4"></view>

		</view>
		<view class="button-space">
			<view class="time-buttons">
				<view class="begin-button">
					<button style="background-color: #25d3fa;">开始计时</button>
				</view>
				<view class="end-button">
					<button style="background-color: #25d3fa;">结束计时</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		methods: {

		}
	}
</script>

<style>
	.container {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
	}

	.temp1 {
		display: flex;
		height: 200rpx;
		width: 100%;

	}

	.temp2 {
		display: flex;
		height: 50rpx;
		width: 100%;

	}

	.temp3 {
		display: flex;
		height: 40rpx;
		width: 100%;
	}

	.temp4 {
		display: flex;
		height: 20rpx;
		width: 100%;
	}

	.study-content {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
	}

	.content-text {
		display: flex;
		height: 100rpx;
		width: 100%;
		align-items: center;
		justify-content: center;
	}

	.content-checkbox {
		display: flex;
		width: 100%;
		height: 150rpx;
	}

	.time-content {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
	}

	.time-text {
		display: flex;
		height: 100rpx;
		width: 100%;
		align-items: center;
		justify-content: center;
	}

	.time-checkbox {
		display: flex;
		width: 100%;
		height: 150rpx;
	}
	.button-space{
		display: flex;
		width: 100%;
		height: 300rpx;
		align-items: center;
		justify-content: center;
	}
	.time-buttons{
		display: flex;
		width: 100%;
		height: 130rpx;
		justify-content: space-between;
	}
	.begin-button{
		display: flex;
		width: 50%;
		height: 100%;
		align-items: center;
		justify-content: center;
	}
	.end-button{
		display: flex;
		width: 50%;
		height: 100%;
		align-items: center;
		justify-content: center;
	}
</style>