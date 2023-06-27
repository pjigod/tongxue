<template>
	<view class="container">
		<view class="search-content">
			<view class="left-icon">
				<img src="../../static/image/search.png" style="height: 100%;width: 100%;"></img>
			</view>
			<view class="searchinput">
				<input type="text" placeholder="uniapp"   style="border-radius: 5rpx; border: solid 1rpx #B3b3b3;width: 90%;height: 60%;" />
			</view>
			<view class="searchtext">
				<text style="font-size: 30rpx;color: #B3b3b3;">筛选</text>
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

</style>
