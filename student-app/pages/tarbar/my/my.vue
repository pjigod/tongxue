<template>
	<view class="container">
		<view class="firsttemp"></view>
		<view class="userInfo">
			<!-- 用户信息 -->
			<view class="userImage">
				<view class="inner_image">
					<img @click="navTo('/pages/login/login')" src="../../../static/image/user.png"
						style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="userName">
				<text>点击头像登录</text>
			</view>
			<view class="userTitle">
				<text>摆烂大王</text>
			</view>
		</view>
		<view class="bigTemp">

		</view>
		<view class="myItems">
			<!-- 我的 -->
			<view class="myCollection">
				<view class="collection-image">
					<view class="collection-inner-icon">
						<img src="../../../static/image/star.png" style="height: 100%;width: 100%;"></img>
					</view>
				</view>
				<view class="collection-text">
					<text style="font-size: 35rpx;">我的收藏</text>
				</view>
				<view class="collection-nextto">
					<img src="../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="ssmalltemp"></view>
			<view class="myLike">
				<view class="like-inner-icon">

				</view>
			</view>
			<view class="ssmalltemp"></view>
			<view class="mycare">
				<view class="care-inner-icon">

				</view>
			</view>
			<view class="ssmalltemp"></view>
			<view class="myfriends">
				<view class="friends-inner-icon">

				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="set">
				<view class="set-inner-icon">

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
		width: 730rpx;
		justify-content: center;
		align-items: center;
		flex-wrap: wrap;
	}

	.userInfo {
		display: flex;
		width: 100%;
		height: 200rpx;
		flex-wrap: wrap;
		gap: 70rpx;
		border-radius: 24rpx;
		background-color: white;
	}

	.userImage {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		width: 120rpx;
		height: 100%;
		margin-left: 40rpx;
	}
	.collection-image{
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		width: 100rpx;
		height: 100%;
		margin-left: 20rpx;
	}
	.inner_image {
		display: flex;
		justify-content: center;
		align-items: center;
		margin-left: 10rpx;
		width: 120rpx;
		height: 100rpx;
		border-radius: 180rpx;
		border: 5rpx solid black;
	}

	.userName {
		display: flex;
		width: 200rpx;
		height: 100%;
		justify-content: center;
		align-items: center;
	}

	.userTitle {
		display: flex;
		width: 150rpx;
		height: 100%;
		align-items: center;
	}

	.bigTemp {
		display: flex;
		width: 100%;
		height: 250rpx;
		background-color: blue;
	}

	.firsttemp {
		display: flex;
		width: 100%;
		height: 100rpx;
		background-color: blue;
	}

	.smalltemp {
		width: 100%;
		height: 18rpx;
		background-color: green;
	}

	.ssmalltemp {
		width: 100%;
		height: 5rpx;
		background-color: green;
	}

	.myItems {
		display: flex;
		width: 100%;
		height: 508rpx;
		flex-wrap: wrap;
		background-color: white;

	}

	.myCollection {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		justify-content: space-between;
		align-items: center;
		/* 	border-radius: 24rpx; */
	}
	.collection-text{
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;

	}
	.collection-nextto{
		display:flex;
		width:65rpx;
		height: 65rpx;
		margin-left: auto;
	}
	.myLike {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		gap: 70rpx;
		background-color: red;
		/* 	border-radius: 24rpx; */
	}

	.mycare {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		gap: 70rpx;
		background-color: red;
		/* 		border-radius: 24rpx; */
	}

	.myfriends {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		gap: 70rpx;
		background-color: red;
		/* border-radius: 24rpx; */
	}

	.set {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		gap: 70rpx;
		background-color: red;
		/* border-radius: 24rpx; */
	}

	.collection-inner-icon {
		height: 65rpx;
		width: 65rpx;
	}

	.like-inner-icon {
		
	}

	.care-inner-icon {
		
	}

	.friends-inner-icon {
		
	}

	.set-inner-icon {
		
	}
</style>