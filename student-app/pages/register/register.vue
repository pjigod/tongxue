<template>
	<view class="container">
		<view class="temp1"></view>
		<view class="inner-text">
			<text
				style="font-size: 50rpx; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">欢迎注册！</text>
		</view>
		<view class="temp2"></view>
		<view class="inputtext">
			<view class="inputtext1">
				<view class="temp7"></view>
				<view class="left-input1">
					<input type="text" style="border: none;height: 100%;" placeholder="输入用户名(数字)" v-model="AccountId" />
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext2">
				<view class="temp7"></view>
				<view class="left-input2">
					<input type="password" style="border: none;height: 100%;" placeholder="输入密码" v-model="Password" />
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext3">
				<view class="temp7"></view>
				<view class="left-input3">
					<input type="password" style="border: none;height: 100%;" placeholder="确认密码" v-model="Confirm" />
				</view>
			</view>
			<view class="smalltemp"></view>
		</view>
		<view class="temp3"></view>
		<view class="loginbutton">
			<button style="border-radius: 45rpx;width: 75%;height: 80%;background-color:#25d3fa;color:darkblue;"
				@click="checkInput();toRegister()">下一步</button>
		</view>
		<view class="temp4"></view>
		<view class="confirm">
			<text>已有账号？</text>
			<text style="color: blue;" @click="navTo('/pages/login/login')">立即登录</text>
		</view>


	</view>
</template>

<script>
	export default {
		data() {
			return {
				AccountId: '',
				Password: '',
				Confirm: '',
				isConfirmed: false,
				isChecked: false
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

			},
			checkInput() {
				// 判断输入值是否为数字
				if (!this.AccountId || !/^[0-9]+$/.test(this.AccountId)) {
					uni.showToast({
						title: '用户名非全数字',
						icon: 'error'
					});
				} else {
					// 如果不是数字，弹出警告框并提醒重新输入

					this.isChecked = true;
					console.log(this.isChecked);
				}
			},
			toRegister() {
				if (this.isChecked === true) {
					if (this.Password === this.Confirm) {
						this.navTo('/pages/emailConfirm/emailConfirm?AccountId='+this.AccountId+'&Password='+this.Password)
						// this.$request({
						// 	url: '/user/register',
						// 	method: 'GET',
						// 	data: {
						// 		AccountId: this.AccountId,
						// 		Password: this.Password
						// 	}
						// }).then(res => {
						// 	console.log(res);
						// 	uni.navigateTo({
						// 			url: '/pages/improve/improve'
						// 		}),
						// 		uni.showToast({
						// 			title: '注册成功'
						// 		})

						// }).catch(err => {
						// 	console.log(err);
						// })
					} else {
						uni.showToast({
							title: '两次密码不同',
							icon: 'error'
						})
					}

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