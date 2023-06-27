<template>
	<view class="container">
		<view class="myItems">
			<view class="myCollection" @click="navTo('/pages/tarbar/my/set/alterpassword')">
				<view class="collection-inner-icon"></view>
				<view class="collection-text">
					<text style="font-size: 35rpx;">修改密码</text>
				</view>
				<view class="collection-nextto">
					<img src="../../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="ssmalltemp"></view>
			<!-- 我的点赞 -->
			<view class="myLike" @click="navTo('/pages/tarbar/my/set/alterimage')">
				<view class="collection-inner-icon"></view>
				<view class="like-text">
					<text style="font-size: 35rpx;">修改头像</text>
				</view>
				<view class="like-nextto">
					<img src="../../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="ssmalltemp"></view>
			<!-- 我的关注 -->
			<view class="mycare" @click="navTo('/pages/tarbar/my/set/alteremail')">
				<view class="collection-inner-icon"></view>
				<view class="care-text">
					<text style="font-size: 35rpx;">修改邮箱</text>
				</view>
				<view class="care-nextto">
					<img src="../../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="ssmalltemp"></view>
			<!-- 我的好友 -->
			<view class="myfriends" @click="navTo('/pages/tarbar/my/set/alterphone')">
				<view class="collection-inner-icon"></view>
				<view class="friends-text">
					<text style="font-size: 35rpx;">修改手机号</text>
				</view>
				<view class="friends-nextto">
					<img src="../../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="smalltemp"></view>
			<!-- 我的设置 -->
			<view class="set" @click="navTo('/pages/tarbar/my/set/abouttongxue')">
				<view class="collection-inner-icon"></view>
				<view class="set-text">
					<text style="font-size: 35rpx;">关于同学</text>
				</view>
				<view class="set-nextto">
					<img src="../../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
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
		justify-content: center;
		align-items: center;
		flex-wrap: wrap;
		background-color: white;
	}
	
	.myItems {
		display: flex;
		width: 100%;
		height: 538rpx;
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
	
	.collection-text {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
	
	}
	
	.collection-nextto {
		display: flex;
		width: 65rpx;
		height: 65rpx;
		margin-left: auto;
	}
	
	.myLike {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		justify-content: space-between;
		align-items: center;
		/* 	border-radius: 24rpx; */
	}
	
	.like-image {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		width: 100rpx;
		height: 100%;
		margin-left: 20rpx;
	}
	
	.like-text {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
	}
	
	.like-nextto {
		display: flex;
		width: 65rpx;
		height: 65rpx;
		margin-left: auto;
	}
	
	.mycare {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		justify-content: space-between;
		align-items: center;
		/* 		border-radius: 24rpx; */
	}
	
	.care-image {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		width: 100rpx;
		height: 100%;
		margin-left: 20rpx;
	}
	
	.care-text {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
	}
	
	.care-nextto {
		display: flex;
		width: 65rpx;
		height: 65rpx;
		margin-left: auto;
	}
	
	.myfriends {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		justify-content: space-between;
		align-items: center;
		/* border-radius: 24rpx; */
	}
	
	.friends-image {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		width: 100rpx;
		height: 100%;
		margin-left: 20rpx;
	}
	
	.friends-text {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
	}
	
	.friends-nextto {
		display: flex;
		width: 65rpx;
		height: 65rpx;
		margin-left: auto;
	}
	
	.set {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
		justify-content: space-between;
		align-items: center;
		/* border-radius: 24rpx; */
	}
	
	.set-image {
		display: flex;
		align-items: center;
		flex-wrap: wrap;
		width: 100rpx;
		height: 100%;
		margin-left: 20rpx;
	}
	
	.set-text {
		display: flex;
		justify-content: center;
		align-items: center;
		height: 100%;
	}
	
	.set-nextto {
		display: flex;
		width: 65rpx;
		height: 65rpx;
		margin-left: auto;
	}
	
	.collection-inner-icon {
		height: 65rpx;
		width: 65rpx;
	}
	
</style>
