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
					<input type="text" style="border: none;height: 100%;" placeholder="请输入用户名" />
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext2">
				<view class="temp7"></view>
				<view class="left-input2">
					<input type="password" style="border: none;height: 100%;" placeholder="请输入密码" />
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext3">
				<view class="temp7"></view>
				<view class="left-input3">
					<input type="password" style="border: none;height: 100%;" placeholder="请确认密码" />
				</view>
			</view>
			<view class="smalltemp"></view>
		</view>
		<view class="temp3"></view>
		<view class="loginbutton">
			<button style="border-radius: 45rpx;width: 75%;height: 80%;background-color:#25d3fa;color:darkblue;"
				@click="toRegister">注册</button>
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
			toRegister(){
				uni.navigateBack();
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