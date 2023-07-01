<template>
	<view class="container">
		<view class="temp1"></view>
		<view class="inner-text">
		</view>
		<view class="temp2"></view>
		<view class="inputtext">
			<view class="inputtext1">
				<view class="temp7"></view>
				<view class="left-input1">
					<input type="password" style="border: none;height: 100%;" placeholder="请输入新密码" v-model="Password"/>
				</view>
			</view>
			<view class="smalltemp"></view>
			<view class="inputtext2">
				<view class="temp7"></view>
				<view class="left-input2">
					<input type="password" style="border: none;height: 100%;" placeholder="请确认新密码" v-model="Confirm"/>
				</view>
			</view>
			<view class="smalltemp"></view>
		</view>
		<view class="temp3"></view>
		<view class="loginbutton">
			<button style="border-radius: 45rpx;width: 75%;height: 80%;background-color:#25d3fa;color:darkblue;"
				@click="toconfirm">确认</button>
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
				Password:'',
				Confirm:'',
				isConfirmed:false
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
			toconfirm(){
				if(this.Password===this.Confirm){
					this.isConfirmed=true;
					this.$request({
						url:'/user/update/password',
						method:'GET',
						data:{
							AccountId:this.accountId,
							Password:this.Password
						}
					}).then(res=>{
							console.log(res);
							uni.showToast({
								title:'修改成功'
							}),
							uni.switchTab({
								url:'/pages/tarbar/my/my'
							})
						
					}).catch(err=>{
						console.log(err);
					})
				}
				else{
					uni.showToast({
						title:'两次密码不同',
						icon:'error'
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