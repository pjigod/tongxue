<template>
	<view class="container">
		<view class="firsttemp"></view>
		<view class="userInfo">
			<!-- 用户信息 -->
			<view class="userImage">
				<view class="inner_image">
					<img @click="loginStatus?navTo('/pages/tarbar/my/set/set'):navTo('/pages/login/login')"
						:src="loginStatus ? photo : '../../../static/image/user.png'"
						style="height: 100%;width: 100%;border-radius: 50%;"></img>
				</view>
			</view>
			<view class="userName">
				<text>{{loginStatus?nickname:'点击头像登录'}}</text>
			</view>
			<view class="userTitle">
				<text>摆烂大王</text>
			</view>
		</view>
		<view class="bigTemp">

		</view>
		<view class="myItems">
			<!-- 我的收藏 -->
			<view class="myCollection" @click="navTo('/pages/tarbar/my/myCollection');alarm()">
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
			<!-- 我的点赞 -->
			<view class="myLike" @click="navTo('/pages/tarbar/my/mylike');alarm()">
				<view class="like-image">
					<view class="like-inner-icon">
						<img src="../../../static/image/header.png" style="height: 100%;width: 100%;"></img>
					</view>
				</view>
				<view class="like-text">
					<text style="font-size: 35rpx;">我的点赞</text>
				</view>
				<view class="like-nextto">
					<img src="../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="ssmalltemp"></view>
			<!-- 我的关注 -->
			<view class="mycare" @click="navTo('/pages/tarbar/my/mycare');alarm()">
				<view class="care-image">
					<view class="care-inner-icon">
						<img src="../../../static/image/mycare.png" style="height: 100%;width: 100%;"></img>
					</view>
				</view>
				<view class="care-text">
					<text style="font-size: 35rpx;">我的关注</text>
				</view>
				<view class="care-nextto">
					<img src="../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="ssmalltemp"></view>
			<!-- 我的好友 -->
			<view class="myfriends" @click="navTo('/pages/tarbar/my/myfriends/myfriends');alarm()">
				<view class="friends-image">
					<view class="friends-inner-icon">
						<img src="../../../static/image/friends.png" style="height: 100%;width: 100%;"></img>
					</view>
				</view>
				<view class="friends-text">
					<text style="font-size: 35rpx;">我的好友</text>
				</view>
				<view class="friends-nextto">
					<img src="../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
			<view class="smalltemp"></view>
			<!-- 我的设置 -->
			<view class="set" @click="navTo('/pages/tarbar/my/set/set');alarm()">
				<view class="set-image">
					<view class="set-inner-icon">
						<img src="../../../static/image/set.png" style="height: 100%;width: 100%;"></img>
					</view>
				</view>
				<view class="set-text">
					<text style="font-size: 35rpx;">设置</text>
				</view>
				<view class="set-nextto">
					<img src="../../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
				</view>
			</view>
		</view>
		<view class="exit">
			<view class="exit-text"><text style="font-size: 40rpx;color: red;" @click="exit">退出登录</text></view>

		</view>
	</view>
</template>

<script>
	import {
		mapState,
		mapMutations
	} from 'vuex'
	export default {
		data() {
			return {
				nickname: '',
				photo: '',
			}
		},
		computed: {
			...mapState({
				loginStatus: state => state.user.loginStatus,
				accountId: state => state.user.accountId
			}),

		},
		onShow() {
			let name = uni.getStorageSync('nickName');
			this.nickname = name;
			this.photo = 'http://121.43.48.56/user/avatar?AccountId=' + this.accountId;

		},
		// lifetimes: {
		// 	ready() {
		// 		this.setData({
		// 			nickname: uni.getStorageSync("nickName"),
		// 		});
		// 		console.log(nickname);
		// 	},
		// },
		methods: {
			...mapMutations(['hasLogout']),
			alarm() {
				if (!this.loginStatus) {
					uni.showToast({
						title: '请先进行登录',
						icon: 'error',
					})
					console.log(this.loginStatus)
				}
			},
			navTo(url) {
				console.log('跳转路径', url);
				if (!this.loginStatus) {
					url = '/pages/login/login';
				}
				uni.navigateTo({
					url
				});
			},
			exit() {
				this.hasLogout();
				uni.showToast({
					title: '退出登录',
					duration: 1500,
				})
			}
		}
	}
</script>

<style>
	.container {
		display: flex;
		width: 741rpx;
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

	.collection-image {
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

	}

	.firsttemp {
		display: flex;
		width: 100%;
		height: 100rpx;

	}

	.smalltemp {
		width: 100%;
		height: 18rpx;

	}

	.ssmalltemp {
		width: 100%;
		height: 5rpx;

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

	.like-inner-icon {
		height: 55rpx;
		width: 55rpx;
		margin-left: 7rpx;
	}

	.care-inner-icon {
		height: 65rpx;
		width: 65rpx;
	}

	.friends-inner-icon {
		height: 65rpx;
		width: 65rpx;
	}

	.set-inner-icon {
		height: 65rpx;
		width: 65rpx;
	}

	.exit {
		display: flex;
		width: 100%;
		height: 200rpx;
		justify-content: center;
		align-items: center;
	}
</style>