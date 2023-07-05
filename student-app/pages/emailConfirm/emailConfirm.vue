<template>
	<view class="container">
		<view class="temp1"></view>
		<view class="inner-text">
			<text
				style="font-size: 50rpx; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">绑定邮箱</text>
		</view>
		<view class="temp2"></view>
		<view class="inputtext">
			<!-- 			<view class="inputtext1">
				<view class="temp7"></view>
				<view class="left-input1">
					<input type="text" style="border: none;height: 100%;" placeholder="请输入用户名" />
				</view>
			</view>
			<view class="smalltemp"></view> -->
			<view class="inputtext2">
				<view class="temp7"></view>
				<view class="left-input2">
					<input type="text" style="border: none;height: 100%;" placeholder="请输入邮箱" v-model="email" />
				</view>
				<view class="right-icon1">
					<view class="registertext"><text style="color: gray;" @click="sendconfirm">发送验证码</text></view>
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext3">
				<view class="temp7"></view>
				<view class="left-input3">
					<input type="text" style="border: none;height: 100%;" placeholder="填写验证码" v-model="confirmCode" />
				</view>
			</view>
			<view class="smalltemp"></view>
		</view>
		<view class="temp3"></view>
		<view class="loginbutton">
			<button style="border-radius: 45rpx;width: 75%;height: 80%;background-color:#25d3fa;color:darkblue;"
				@click="toconfirm">注册</button>
		</view>



	</view>
</template>

<script>
	import {
		mapMutations,
		mapState,
	} from 'vuex'
	export default {
		data() {
			return {
				AccountId: '',
				Password: '',
				email: '',
				confirmCode: ''
			}
		},
		onLoad(options) {
			// console.log(options.AccountId) // 输出 123
			// console.log(options.Password) // 输出 uni-app
			this.AccountId = options.AccountId;
			this.Password = options.Password;
			console.log(this.AccountId)
		},
		computed: {
			...mapState({
				loginStatus: state => state.user.loginStatus,
				accountId: state => state.user.accountId,
			})
		},
		methods: {
			...mapMutations(['hasLogin', 'setAccountId']),
			navTo(url) {
				console.log('跳转路径', url);
				/*if (!this.hasLogin) {
					url = '/pages/login/login';
				}*/
				uni.navigateTo({
					url
				});

			},
			sendconfirm() {
				this.$request({
					url: '/email',
					methods: 'GET',
					data: {
						EMail: this.email
					}

				}).then(res => {
					console.log(res);
				}).then(err => {
					console.log(err);
				})
			},
			toconfirm() {
				this.$request({
					url: '/user/register',
					methods: 'GET',
					data: {
						AccountId: this.AccountId,
						Password: this.Password,
						EMail: this.email,
						Code: this.confirmCode

					}
				}).then(res => {
					if (res === true) {
						uni.showToast({
								title: '注册成功'
							}),
							this.hasLogin(res);
						this.setAccountId(this.AccountId);
						uni.setStorageSync('email', this.email);
						this.navTo('/pages/improve/improve')
					} else {
						uni.showToast({
							title: '验证码错误',
							icon: 'error'
						})
					}
				}).catch(err => {
					uni.showToast({
						title: '注册失败',
						icon: 'error'
					})
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

	.temp1 {
		display: flex;
		width: 100%;
		height: 280rpx;

	}

	.temp2 {
		display: flex;
		width: 100%;
		height: 100rpx;

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
		height: 275rpx;
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

	.right-icon1 {
		display: flex;
		height: 100%;
		width: 20%;

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