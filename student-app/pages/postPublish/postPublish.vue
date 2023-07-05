<template>
	<view class="container">
		<view class="publish">
			<view class="temp1">

			</view>
			<view class="publish-text">
				<text style="font-size: 55rpx;">发布帖子</text>
			</view>
			<view class="publish-button" @click="toSubmit">
				<text style="color: #636263;font-size: 30rpx;">发布</text>
			</view>
		</view>
		<view class="smalltemp"></view>
		<view class="postpicker">
			<view class="picker-image">
				<img src="../../static/image/selectpicker.png" style="height: 60rpx;width: 60rpx;"></img>
			</view>
			<view class="picker">
				<picker :range="array" range-key="name" @change="bindPickerChange" style="font-size: 35rpx;">
					<!-- {{array[index].name}} -->
					{{type}}
				</picker>
			</view>
			<view class="next">
				<img src="../../static/image/arrow.png" style="height: 100%;width: 100%;"></img>
			</view>
		</view>
		<view class="smalltemp"></view>
		<view class="postTitle">
			<input type="text" placeholder="请输入帖子标题" style="font-size: 40rpx; " v-model="title" />
		</view>
		<view class="smalltemp"></view>
		<view class="postBrief">
			<textarea placeholder="请输入帖子简介(不得超过100字)" v-model="brief" style="font-size: 40rpx;"
				maxlength='100'></textarea>
		</view>
		<view class="smalltemp"></view>
		<view class="postCover">
			<text style="font-size: 40rpx;width: 100%;color: #636263;">请选择帖子封面</text>
			<view @click="toalterImage">
				<img :src="photo" style="height: 350rpx;width: 350rpx;"></img>
			</view>
		</view>
		<view class="smalltemp"></view>
		<view class="postText">
			<textarea placeholder="请输入帖子内容" v-model="content" style="font-size: 40rpx;" auto-height="true"></textarea>
		</view>
	</view>

</template>

<script>
	import {
		mapState
	} from 'vuex'
	export default {
		data() {
			return {
				title: '',
				content: '',
				brief: '',
				photo: '../../static/image/cover.png',
				array: [{
					name: 'springboot'
				}, {
					name: 'web'
				}, {
					name: 'cpp'
				}, {
					name: 'java'
				}, {
					name: 'uml'
				}, {
					name: 'python'
				}],
				index: 0,
				type: '帖子类型',
				tempFilePaths: [],
			}
		},
		// onShow() {
		// 	this.photo = 'http://121.43.48.56/user/avatar?AccountId=' + this.accountId;
		// },
		computed: {
			...mapState({
				// loginStatus: state => state.user.loginStatus,
				accountId: state => state.user.accountId
			}),

		},
		methods: {
			bindPickerChange(e) {
				this.index = e.detail.value;
				this.type = this.array[e.detail.value].name;
			},
			toSubmit() {
				console.log(this.title);
				console.log(this.content);
				console.log(this.accountId);
				console.log(this.brief);
				console.log(this.type);
				console.log(this.tempFilePaths[0]);

				uni.uploadFile({
					url: 'http://121.43.48.56/post/upload', //上传图片api
					filePath: this.tempFilePaths[0],
					name: 'Cover',
					formData: {
						AccountId: this.accountId,
						Title: this.title,
						Content: this.content,
						Brief: this.brief,
						Type: this.type
					},
					success: (res) => {
						uni.showToast({
							title: "发帖成功",
							icon: "success"
						})
						uni.navigateBack()
					},
					fail:(err)=> {
						console.log(err);
					}
				});


			},
			toalterImage() {
				uni.chooseImage({
					count: 1, // 图片数量
					sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['album', 'camera'], //从相册选择或者拍照
					success: (res) => {
						this.tempFilePaths = res.tempFilePaths;
						console.log(this.tempFilePaths[0]);
						this.photo = this.tempFilePaths[0];

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
		},

	}
</script>

<style>
	.smalltemp {
		display: flex;
		width: 100%;
		height: 1rpx;
		background-color: #636263;
	}

	.container {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
	}

	.publish {
		display: flex;
		width: 100%;
		height: 100rpx;
		flex-wrap: wrap;
	}

	.temp1 {
		display: flex;
		width: 15%;
	}

	.publish-text {
		display: flex;
		width: 70%;
		justify-content: center;
		align-items: center;
	}

	.publish-button {
		display: flex;
		width: 15%;
		justify-content: center;
		align-items: center;
	}

	.postpicker {
		display: flex;
		width: 100%;
		height: 100rpx;
		justify-content: space-between;
	}

	.picker-image {
		display: flex;
		width: 10%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}

	.next {
		display: flex;
		width: 10%;
		height: 100%;
		margin-left: auto;
		justify-content: center;
		align-items: center;
	}

	.picker {
		width: 80%;
		display: flex;
		height: 100%;

		align-items: center;
	}

	.postTitle {
		width: 100%;
		height: 100rpx;
		display: flex;
		align-items: center;
	}

	.postBrief {
		width: 100%;
		height: 300rpx;
	}

	.postCover {
		display: flex;
		flex-wrap: wrap;
		width: 100%;
		justify-content: center;
		align-items: center;
	}
</style>