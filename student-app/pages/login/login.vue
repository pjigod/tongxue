<template>
	<view class="container">
		<view class="temp1"></view>
		<view class="inner-text">
			<text
				style="font-size: 50rpx; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">欢迎回来！</text>
		</view>
		<view class="temp2"></view>
		<view class="inputtext">
			<view class="inputtext1">
				<view class="temp7"></view>
				<view class="left-input1">
					<input type="text" style="border: none;height: 100%;" placeholder="请输入用户名" />
				</view>
				<view class="right-icon1">
					<view class="registertext"><text style="color: gray;"
							@click="navTo('/pages/register/register')">点击注册</text></view>
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext2">
				<view class="temp7"></view>
				<view class="left-input2">
					<input type="password" style="border: none;height: 100%;" placeholder="请输入密码" />
				</view>
				<view class="right-icon2">
					<view class="forgettext"><text style="color: gray;"
							@click="navTo('/pages/forget/forget')">忘记密码</text></view>
				</view>
			</view>
			<view class="smalltemp"></view>
		</view>
		<view class="temp3"></view>
		<view class="loginbutton">
			<button style="border-radius: 45rpx;width: 75%;height: 80%;background-color:#25d3fa;color:black;"
				@click="toLogin">登录</button>
		</view>
		<view class="temp4"></view>
		<view class="confirm">
			<checkbox style=" border-radius: 50%;align-items: center;justify-content: center;" id="shouldknow"
				:checked="ischecked" @click="change">
				您已阅读并同意</checkbox><text style="font-weight: bold;"
				@click="navTo('/pages/login/shouldknow')">《“同学”服务协议》</text>
		</view>
		<view class="temp5"></view>
		<view class="otherlogin-text">
			<text style="color: gray;">-其他登录方式-</text>
		</view>
		<view class="temp6">

		</view>
		<view class="otherLogin">
			<view class="wechat">
				<uni-icons type="weixin" size="30" @click="weixin"></uni-icons>
			</view>
			<view class="qq">
				<uni-icons type="qq" size="30" @click="qq"></uni-icons>
			</view>
			<view class="email">
				<uni-icons type="email" size="30" @click="email"></uni-icons>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				ischecked: false
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
			toLogin() {
				if (this.ischecked) {
					uni.switchTab({
						url: "/pages/tarbar/forum/forum"
					})
					
					
				} else {
					uni.showToast({
						title: '请先同意协议',
						duration: 1500,
						icon: 'error'
					})
				}
			},
			change() {
				if (!this.ischecked) {
					this.ischecked = true;
				} else {
					this.ischecked = false;
				}
			},
			weixin() {
				uni.showToast({
					title: '微信',
					duration: 1500,
					icon: 'none'
				})
			},
			qq() {
				uni.showToast({
					title: 'qq',
					duration: 1500,
					icon: 'none'
				})
			},
			email() {
				uni.showToast({
					title: 'email',
					duration: 1500,
					icon: 'none'
				})
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
		height: 50rpx;

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
		height: 250rpx;
		flex-wrap: wrap;
	}

	.inputtext1 {
		display: flex;
		width: 100%;
		height: 120rpx;

	}

	.left-input1 {
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
		width: 65%;
		height: 100%;
	}

	.left-input2 {
		width: 65%;
		height: 100%;
	}

	.right-icon2 {
		display: flex;
		height: 100%;
		width: 20%;
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