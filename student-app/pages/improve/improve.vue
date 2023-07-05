<template>
	<view class="container">
		<view class="temp2">
			<view class="ignore-text">
				<text style="color: B3b3b3; font-size: 40rpx;" @click="ignore">跳过</text>
			</view>
		</view>
		<view class="inner-text">
			<text
				style="font-size: 50rpx; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">请修改个人信息</text>
		</view>
		<view class="temp1">
			<view class="alterimg" @click="toalterImage()">
				<img :src='photo' style="width: 100%;height:100%;border-radius: 50%;">
			</view>
		</view>
		<view class="temp3"></view>
		<view class="inputtext">
			<view class="inputtext1">
				<view class="temp7"></view>
				<view class="left-input1">
					<input type="text" style="border: none;height: 100%;" placeholder="请输入昵称" v-model="nickname" />
				</view>
			</view>
			<view class="smalltemp"></view>
			<!-- 	<view class="inputtext2">
				<view class="temp7"></view>
				<view class="left-input2">
					<input type="text" style="border: none;height: 100%;" placeholder="请输入邮箱" v-model="email" />
				</view>
			</view>
			<view class="smalltemp"></view>
 -->

		</view>
		<view class="temp3"></view>
		<view class="loginbutton">
			<button style="border-radius: 45rpx;width: 75%;height: 80%;background-color:#25d3fa;color:darkblue;"
				@click="toSubmit">提交</button>
		</view>
		<view class="temp4"></view>


	</view>
</template>

<script>
	import {
		mapState
	} from 'vuex'
	export default {
		data() {
			return {
				nickname: '',
				email: '',
				photo: '../../static/image/person.png'
			}
		},
		computed: {
			...mapState({
				accountId: state => state.user.accountId,
			})
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

			},
			toalterImage() {
				uni.chooseImage({
					count: 1, // 图片数量
					sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['album', 'camera'], //从相册选择或者拍照
					success: (res) => {
						const tempFilePaths = res.tempFilePaths;
						console.log(tempFilePaths[0]);
						this.photo=tempFilePaths[0];
						// uni.uploadFile({
						// 	url: 'http://121.43.48.56/upload', //上传图片api
						// 	filePath: tempFilePaths[0],
						// 	name: 'photo',
						// 	formData: {
						// 		AccountId: this.accountId
						// 	},
						// 	success: (res) => {
						// 		uni.showToast({
						// 			title: "上传成功",
						// 			icon: "success"
						// 		})
						// 		uni.navigateBack()
						// 	}
						// });
					}
				})
			},
			ignore() {
				this.$request({
					url: '/user/update/nickname',
					method: 'GET',
					data: {
						AccountId: this.accountId,
						NickName: this.accountId
					}
				}).then(res => {
					console.log(res);
					uni.setStorageSync('nickName', this.accountId),
						uni.switchTab({
							url: '/pages/tarbar/my/my'
						})

				}).catch(err => {
					console.log(err);
				})
			},
			toSubmit() {
				if (this.nickname != '') {
					this.$request({
						url: '/user/update/nickname',
						method: 'GET',
						data: {
							AccountId: this.accountId,
							NickName: this.nickname
						}
					}).then(res => {
						console.log(res);
						uni.setStorageSync('nickName', this.nickname),
							uni.switchTab({
								url: '/pages/tarbar/my/my'
							})

					}).catch(err => {
						console.log(err);
					});
					uni.uploadFile({
						url: 'http://121.43.48.56/upload', //上传图片api
						filePath: tempFilePaths[0],
						name: 'photo',
						formData: {
							AccountId: this.accountId
						}
					});
				} else {
					this.$request({
						url: '/user/update/nickname',
						method: 'GET',
						data: {
							AccountId: this.accountId,
							NickName: this.accountId
						}
					}).then(res => {
						console.log(res);
						uni.setStorageSync('nickName', this.accountId),
							uni.switchTab({
								url: '/pages/tarbar/my/my'
							})

					}).catch(err => {
						console.log(err);
					})
				}
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

	.temp1 {
		display: flex;
		width: 100%;
		height: 280rpx;
		justify-content: center;
		align-items: center;
	}

	.alterimg {
		display: flex;
		height: 200rpx;
		width: 200rpx;
		border-radius: 50%;
		border: solid 1rpx black;
	}

	.temp2 {
		display: flex;
		width: 100%;
		height: 100rpx;
		justify-content: flex-end;
	}

	.ignore-text {
		display: flex;
	}

	.temp3 {
		display: flex;
		width: 100%;
		height: 120rpx;

	}

	.temp4 {
		display: flex;
		width: 100%;
		height: 20rpx;

	}

	.temp5 {
		display: flex;
		width: 100%;
		height: 150rpx;

	}

	.temp6 {
		display: flex;
		width: 100%;
		height: 20rpx;

	}

	.temp7 {
		display: flex;
		height: 100%;
		width: 15%;
	}

	.temp8 {
		height: 100%;
		width: 15%;
	}

	.smalltemp {
		display: flex;
		width: 100%;
		height: 5rpx;
		background-color: gray;
	}

	.inputtext {
		display: flex;
		width: 100%;

		flex-wrap: wrap;
	}

	.inputtext1 {
		display: flex;
		width: 100%;
		height: 120rpx;

	}

	.left-input1 {
		display: flex;
		width: 65%;
		height: 100%;
	}

	.registertext {
		display: flex;
		align-items: center;
		justify-content: center;
	}

	.inputtext2 {
		display: flex;
		width: 100%;
		height: 120rpx;
	}

	.left-input1 {
		display: flex;
		width: 65%;
		height: 100%;
	}

	.left-input2 {
		width: 65%;
		display: flex;
		height: 100%;
	}

	.inputtext3 {
		display: flex;
		width: 100%;
		height: 120rpx;

	}

	.left-input3 {
		width: 65%;
		display: flex;
		height: 100%;
	}

	.forgettext {
		display: flex;
		align-items: center;
		justify-content: center;
	}

	.loginbutton {
		display: flex;
		width: 100%;
		height: 100rpx;
		justify-content: center;
		align-items: center;

	}

	.confirm {
		display: flex;
		width: 100%;
		height: 60rpx;
		justify-content: center;
		align-items: center;
	}

	.otherlogin-text {
		display: flex;
		width: 100%;
		height: 50rpx;
		justify-content: center;
		align-items: center;
	}

	.otherLogin {
		display: flex;
		width: 100%;
		height: 100rpx;
		justify-content: center;
		align-items: center;
		gap: 20rpx;
	}
</style>