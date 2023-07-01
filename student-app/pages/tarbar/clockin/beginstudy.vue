<template>
	<view class="container">
		<view class="temp1"></view>
		<view class="study-content">
			<view class="temp2"></view>
			<view class="content-text">
				<text style="font-size: 40rpx;">本次学习内容:</text>
			</view>
			<view class="temp3"></view>
			<view class="content-checkbox">
				<view class="data-text"><text style="font-size: 35rpx;">当前选择为：</text></view>
				<view class="data-picker">
					<picker :range="array" range-key="name" value="1" @change="bindPickerChange"
						style="font-size: 35rpx;">
						{{array[index].name}}
					</picker>
				</view>

			</view>
			<view class="temp4"></view>
		</view>
		<view class="temp5"></view>
		<view class="time-content">
			<view class="temp2"></view>
			<view class="time-text">
				<text style="font-size: 40rpx;">本次学习时间:</text>
			</view>
			<view class="temp3"></view>
			<view class="time-checkbox">
				<view class="data-text"><text style="font-size: 35rpx;">当前选择为：</text></view>
				<view class="data-picker">
					<!-- <picker mode='time' start="00:00" end="24:00" @change="bindTimeChange">{{time}}</picker> -->
					<picker mode="multiSelector" @columnchange="bindMultiPickerColumnChange" :value="multiIndex"
						:range="multiArray">
						<view class="uni-input">{{hour}}时{{minute}}分
						</view>
					</picker>
				</view>



			</view>
			<view class="temp4"></view>

		</view>
		<view class="button-space">
			<view class="time-buttons">
				<view class="begin-button">
					<button style="background-color: #25d3fa;" @click="beginstudy()">开始计时</button>
				</view>
				<view class="end-button">
					<button style="background-color: #25d3fa;" @click="endCountDown">结束计时</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
import {mapState} from 'vuex'
	export default {
		data() {
			return {
				multiArray: [

					['0', '1', '2', '3', '4', '5'],
					['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15',
						'16',
						'17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31', '32',
						'33', '34', '35', '36', '37', '38', '39', '40', '41', '42', '43', '44', '45', '46', '47', '48',
						'49', '50', '51', '52', '53', '54', '55', '56', '57', '58', '59', '60'
					]
				],
				multiIndex: [0, 0],
				array: [{
					name: '请选择'
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
				minute: 0,
				hour: 0,
				finalhour:0,
				finalminute:0,
				data:'数据结构',
				dataStatus:false,
				timeStatus:false,
			}
		},
		computed:{
			...mapState({
				accountId: state => state.user.accountId,
			})
		},
		methods: {
			bindMultiPickerColumnChange: function(e) {
				console.log('修改的列为：' + e.detail.column + '，值为：' + e.detail.value);
				this.multiIndex[e.detail.column] = e.detail.value;
				if (e.detail.column == 0) {
					this.hour = this.multiArray[0][e.detail.value];
					this.finalhour = this.multiArray[0][e.detail.value];
				} else if (e.detail.column == 1) {
					this.minute = this.multiArray[1][e.detail.value];
					this.finalminute = this.multiArray[1][e.detail.value];
				}
				if(this.hour!=0||this.minute!=0){
					this.timeStatus=true;
				}
				else{
					this.timeStatus=false;
				}
				this.$forceUpdate();

			},
			bindPickerChange(e) {
				if (e.detail.value == 0) {
					this.dataStatus=false;
					uni.showToast({
						duration: (1500),
						icon: 'error',
						title: "请重新选择"
					})
				} else{
					this.index = e.detail.value;
					this.data=this.array[e.detail.value].name;
					this.dataStatus=true
					}
			},
			bindTimeChange(e) {
				this.time = e.detail.value;
			},
			toSubmit(){
				uni.request({
					url:'http://121.43.48.56/user/clockin',
					method:'GET',
					data:{
						AccountId:this.accountId,
						ClockInhour:this.finalhour,
						Content:this.data,
						ClockInmin:this.finalminute
						
					}
				});
				console.log(this.accountId);
			},
			beginstudy(){
				if(this.dataStatus==true&&this.timeStatus==true){
					uni.showToast({
						title:'开始打卡'
					})
					this.startCountDown();
				}
				if(this.dataStatus==false&&this.timeStatus==true){
					uni.showToast({
						title:'请选择学习内容',
						icon:'error',
						duration:1000
					})
				}
				if(this.dataStatus==true&&this.timeStatus==false){
					uni.showToast({
						title:'请选择学习时间',
						icon:'error',
						duration:1000
					})
				}
				if(this.dataStatus==false&&this.timeStatus==false){
					uni.showToast({
						title:'请选择学习内容和时间',
						icon:'error',
						duration:1000
					})
				}
			},
			startCountDown() {
				// 启动计时器
				this.timer = setInterval(() => {
					
						if(this.minute>=1){
							this.minute--;
						}
						else if(this.hour>=1){
							this.hour--;
							this.minute=59;
						}
						else{
							clearInterval(this.timer);
							uni.showToast({
								title:'本次打卡成功',
						
							})
							console.log(this.finalhour);
							console.log(this.finalminute);
							this.toSubmit();
							// 到时候传到后端
						}
						// console.log(this.hour);
						// console.log(this.minute);
						// console.log(this.finalhour);
						// console.log(this.finalminute);

				}, 1000);
			},
			endCountDown(){
				clearInterval(this.timer);
				uni.showToast({
					title:'本次打卡无效',
					icon:'error'
				});
				setTimeout(function(){
				    uni.switchTab({
				        url: '/pages/tarbar/clockin/clockin'
				    });
				}, 1000); 
			}

		},

	};
</script>

<style>
	.container {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
	}

	.temp1 {
		display: flex;
		height: 200rpx;
		width: 100%;

	}

	.temp2 {
		display: flex;
		height: 50rpx;
		width: 100%;

	}

	.temp3 {
		display: flex;
		height: 40rpx;
		width: 100%;
	}

	.temp4 {
		display: flex;
		height: 20rpx;
		width: 100%;
	}

	.study-content {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		justify-content: center;
		align-items: center;
	}

	.content-text {
		display: flex;
		height: 100rpx;
		width: 100%;
		align-items: center;
		justify-content: center;
	}

	.content-checkbox {
		display: flex;
		width: 60%;
		height: 80rpx;
		justify-content: center;
		align-items: center;
		gap: 20rpx;
		border-bottom: solid 1rpx #bebebe;
	}

	.time-content {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		justify-content: center;
		align-items: center;
	}

	.time-text {
		display: flex;
		height: 100rpx;
		width: 100%;
		align-items: center;
		justify-content: center;
	}

	.time-checkbox {
		display: flex;
		width: 60%;
		height: 80rpx;
		justify-content: center;
		align-items: center;
		gap: 20rpx;
		border-bottom: solid 1rpx #bebebe;
	}

	.button-space {
		display: flex;
		width: 100%;
		height: 300rpx;
		align-items: center;
		justify-content: center;
	}

	.time-buttons {
		display: flex;
		width: 100%;
		height: 130rpx;
		justify-content: space-between;
	}

	.begin-button {
		display: flex;
		width: 50%;
		height: 100%;
		align-items: center;
		justify-content: center;
	}

	.end-button {
		display: flex;
		width: 50%;
		height: 100%;
		align-items: center;
		justify-content: center;
	}
</style>