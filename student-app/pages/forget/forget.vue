<template>
	<view class="container">
		<view class="temp1"></view>
		<view class="inner-text">
			<text
				style="font-size: 50rpx; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">忘记密码</text>
		</view>
		<view class="temp2"></view>
		<view class="inputtext">
			<view class="inputtext2">
				<view class="temp7"></view>
				<view class="left-input2">
					<input type="text" style="border: none;height: 100%;" placeholder="请输入用户名" v-model="accountId" />
				</view>
				<view class="right-icon1">
					<view class="registertext"><text style="color: gray;" @click="sendconfirm">发送验证码</text></view>
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext3">
				<view class="temp7"></view>
				<view class="left-input3">
					<input type="text" style="border: none;height: 100%;" placeholder="填写验证码" v-model="code" />
				</view>
			</view>
			<view class="smalltemp"></view>
		</view>
		<view class="temp3"></view>
		<view class="loginbutton">
			<button style="border-radius: 45rpx;width: 75%;height: 80%;background-color:#25d3fa;color:darkblue;"
				@click="toconfirm">提交</button>
		</view>



	</view>
</template>

<script>
	// import {
	// 	mapMutations,
	// 	mapState,
	// } from 'vuex'
	export default {
		data() {
			return {
				accountId: '',
				code: ''
			}
		},
		// computed: {
		// 	...mapState({
		// 		loginStatus: state => state.user.loginStatus,
		// 		accountId: state => state.user.accountId,
		// 	})
		// },
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
			sendconfirm() {
				this.$request({
					url: '/user/send',
					methods: 'GET',
					data: {
						AccountId: this.accountId
					}

				}).then(res => {
					console.log(res);
					uni.showToast({
						title:'验证码已发送'
					})
				}).then(err => {
					console.log(err);
				})
			},
			toconfirm() {
				this.$request({
					url: '/user/verify',
					methods: 'GET',
					data: {
						AccountId: this.accountId,
						Code:this.code
					}
				
				}).then(res => {
					console.log(res);
					if(res){
						uni.navigateTo({
							url:'/pages/alter/alter?AccountId='+this.accountId
						})
					}
					else {
						uni.showToast({
							title:'验证码错误',
							icon:'error'
						})
					}
				}).then(err => {
					// console.log(err);
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