<template>
	<view class="container">
		<view class="top-switch">
			<view class="single">
				<view class="single-text"> <text style="padding: 10rpx 0;
		color: #49bdfb;
		font-size: 40rpx;
		border-bottom: 6rpx solid #49bdfb;">个人</text></view>
			</view>
			<view class="team">
				<view class="team-text"> <text style="font-size: 40rpx;color: black">团队</text></view>
			</view>
		</view>
		<view class="temp1"></view>
		<view class="clockin-other">
			<view class="temp3"></view>
			<view class="clockin">
				<view class="temp4"></view>
				<view class="clockin-text">
					<text class="inner-text">学习总时长：</text>
					<text class="inner-data">{{studytime}}h</text>
				</view>
			</view>
			<view class="other">
				<view class="ranking">
					<view class="icon">
						<img src="../../../static/image/165ranking.png" style="height: 100%;width: 100%;"
							@click="navTo('/pages/tarbar/clockin/ranking')"></img>
					</view>
				</view>
				<view class="schedule">
					<view class="icon">
						<img src="../../../static/image/schedule.png" style="height: 100%;width: 100%;"
							@click="navTo('/pages/tarbar/clockin/schedule')"></img>
					</view>
				</view>
				<view class="record">
					<view class="icon">
						<img src="../../../static/image/records.png" style="height: 100%;width: 100%;"
							@click="navTo('/pages/tarbar/clockin/record')"></img>
					</view>
				</view>
			</view>
		</view>
		<view class="temp2"></view>
		<view class="begin">
			<view class="begin-button"> <button style="width: 100%;"
					@click="navTo('/pages/tarbar/clockin/beginstudy')">进入学习</button></view>

		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				studytime: 0,
			}
		},
		methods: {
			navTo(url) {
				console.log('跳转路径', url);
				/*if (!this.hasLogin) {
					url = '/pages/login/login';
				}*/
				uni.navigateTo({
					url
				});
			}
		}
	}
</script>

<style>
	.container {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
	}

	.top-switch {
		display: flex;
		width: 100%;
		height: 100rpx;
	}

	.single {
		display: flex;
		width: 50%;
		height: 100%;
		align-items: center;
		justify-content: center;
	}

	.single-text {
		display: flex;
	}

	.team {
		display: flex;
		width: 50%;
		height: 100%;
		align-items: center;
		justify-content: center;
	}

	.team-text {
		display: flex;
	}

	.temp1 {
		display: flex;
		width: 100%;
		height: 130rpx;
	}

	.temp2 {
		display: flex;
		width: 100%;
		height: 100rpx;
	}

	.temp3 {
		display: flex;
		height: 100%;
		width: 25%;
	}

	.temp4 {
		display: flex;
		height: 15%;
		width: 100%;
	}

	.clockin-other {
		display: flex;
		width: 100%;
		height: 700rpx;
	}

	.clockin {
		display: flex;
		width: 50%;
		height: 100%;
		flex-wrap: wrap;
	}

	.clockin-text {
		display: flex;
		height: 50%;
		width: 100%;
		border-radius: 50%;
		border: 5rpx solid black;
		align-items: center;
		justify-content: center;
	}

	.inner-text {
		display: flex;
	}

	.inner-data {}

	.other {
		display: flex;
		width: 25%;
		height: 100%;
		flex-wrap: wrap;
	}

	.ranking {
		display: flex;
		width: 100%;
		height: 33%;
		justify-content: center;
		align-items: center;
	}

	.schedule {
		display: flex;
		width: 100%;
		height: 33%;
		justify-content: center;
		align-items: center;
	}

	.record {
		display: flex;
		width: 100%;
		height: 34%;
		justify-content: center;
		align-items: center;
	}

	.icon {
		display: flex;
		width: 50rpx;
		height: 50rpx;

	}

	.begin {
		display: flex;
		width: 100%;
		height: 150rpx;
		align-items: center;
		justify-content: center;
	}

	.begin-button {
		display: flex;
		width: 250rpx;
		height: 100rpx;
	}
</style>