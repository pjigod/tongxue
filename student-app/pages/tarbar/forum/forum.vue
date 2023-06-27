<template>
	<view class="container">
		<view class="search-content">
			<view class="temp1" @click="navTo('/pages/search/search')">
				<img src="../../../static/image/search.png" style="height: 100%;width: 100%;"></img>
			</view>
			<view class="searchtext">
				<text style="font-size: 50rpx;">同学</text>
			</view>
			<view class="seaech-icon">

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

	.search-content {
		height: 100rpx;
		width: 100%;
		display: flex;
		align-items: center;
	}

	.temp1 {
		display: flex;
		height: 60rpx;
		width: 8%;
		margin-left: 15rpx;
	}

	.searchtext {
		display: flex;
		width: 84%;
		height: 100%;
		justify-content: center;
		align-items: center;

	}

	.seaech-icon {
		display: flex;
		height: 60rpx;
		width: 8%;
		margin-right: 15rpx;
	}
</style>