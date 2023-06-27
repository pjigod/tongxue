<template>
	<view class="container">
		<view class="search-content">
			<view class="left-icon">
				<img src="../../static/image/search.png" style="height: 100%;width: 100%;"></img>
			</view>
			<view class="searchinput">
				<input type="text" placeholder="uniapp"
					style="border-radius: 5rpx; border: solid 1rpx #B3b3b3;width: 90%;height: 60%;" />
			</view>
			<view class="searchtext" @click="navTo('/pages/searchlist/searchlist')">
				<text style="font-size: 30rpx;color: #B3b3b3;">搜索</text>
			</view>
		</view>
		<view class="lines"></view>
		<view class="searchitems">
			<view class="headtext">
				<view class="left-text">
					<text>最近搜索</text>
				</view>
				<view class="right-icon">
					<img src="../../static/image/垃圾桶.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="concreteitems">
				<view class="item1">
					web
				</view>
				<view class="item2">
					java
				</view>
			</view>
			<view class="left-text">
				<text>热门搜索</text>
			</view>
			<view class="concreteitems">
				<view class="item1">
					web
				</view>
				<view class="item2">
					java
				</view>
				<view class="item2">
					cpp
				</view>
				<view class="item2">
					python
				</view>
				<view class="item2">
					c
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

	.left-icon {
		display: flex;
		height: 60rpx;
		width: 8%;
		margin-left: 15rpx;
	}

	.searchinput {
		display: flex;
		width: 70%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}

	.searchtext {
		display: flex;
		height: 100%;
		width: 10%;
		justify-content: center;
		align-items: center;
	}

	.lines {
		width: 100%;
		height: 2rpx;
		background-color: #e1e1e1;
	}

	.searchitems {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		padding: 20rpx;
	}

	.left-text {
		margin-left: 15rpx;
		margin-top: 10rpx;
	}

	.right-icon {
		display: flex;
		width: 40rpx;
		height: 40rpx;

	}

	.headtext {
		display: flex;
		width: 100%;
		height: 50rpx;
		justify-content: space-between;
		align-items: center;
	}

	.concreteitems {
		display: flex;
		width: 100%;
		gap: 20rpx;
		flex-wrap: wrap;
	}

	.item1 {
		padding: 4rpx 24rpx;
		background-color: #e1e1e1;
		display: inline-block;
		border-radius: 26rpx;
		margin: 20rpx;
	}

	.item2 {
		padding: 4rpx 24rpx;
		background-color: #e1e1e1;
		display: inline-block;
		border-radius: 26rpx;
		margin: 20rpx;
	}
</style>