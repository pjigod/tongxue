<template>
	<view class="container">
		<view class="temp">

		</view>
		<view class="altertext">
			<text style="font-size: 50rpx;">修改头像</text>
		</view>
		<view class="temp">

		</view>
		<view class="alterImage" @click="toalterImage()">
			<!-- <img  :src=photo ></img> -->
			<image :src='photo' style="width: 350rpx; height: 350rpx;border-radius: 50%;"></image>
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
				photo: ''
			}
		},
		computed: {
			...mapState({
				// loginStatus: state => state.user.loginStatus,
				accountId: state => state.user.accountId
			}),

		},
		onShow() {
			this.photo = 'http://121.43.48.56/user/avatar?AccountId=' + this.accountId;
		},
		methods: {
			toalterImage() {
				uni.chooseImage({
					count: 1, // 图片数量
					sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['album', 'camera'], //从相册选择或者拍照
					success: (res) => {
						const tempFilePaths = res.tempFilePaths;
						console.log(tempFilePaths[0])
						uni.uploadFile({
							url: 'http://121.43.48.56/upload', //上传图片api
							filePath: tempFilePaths[0],
							name: 'photo',
							formData:{
								AccountId:this.accountId
							},
							success: (res) => {
								uni.showToast({
									title: "上传成功",
									icon: "success",
									duration:1500
								})
								uni.navigateBack()
							}
						});
					}
				})
			}
		}
	}
</script>

<style>
	.container {
		width: 100%;
	}

	.temp {
		width: 100%;
		height: 100rpx;
	}

	.alterImage {
		display: flex;
		width: 100%;
		height: 400rpx;
		justify-content: center;
		align-items: center;
	}

	.altertext {
		display: flex;
		width: 100%;
		height: 100rpx;
		justify-content: center;
		align-items: center;
	}
</style>