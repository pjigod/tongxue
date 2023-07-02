<template>
	<!-- <view>
	    <text v-for="(item, index) in dataList" :key="index">{{ item.totaltime}}</text>
	  </view> -->
	<view class="container">
		<view class="temp1">

		</view>
		<view class="ranking-text">
			<view class="inner-icon">
				<image src="../../../static/image/排行.png" style="	width: 100rpx;
		height: 100rpx;"></image>
			</view>
			<view class="inner-text">
				<text style="font-size: 50rpx;">打卡排行榜</text>
			</view>
		</view>
		<view class="four-text">
			<text style="font-size: 35rpx;">排名</text>
			<text style="font-size: 35rpx;">用户名</text>
			<text style="font-size: 35rpx;">昵称</text>
			<text style="font-size: 35rpx;">打卡总时长</text>
		</view>
		<view class="items">
			<rankitem v-for="(rankitem,index) in dataList" :key="index" :ranking="index" :accountId="rankitem.accountId"
				:nickName="rankitem.nickName" :totaltime="rankitem.totaltime"></rankitem>


		</view>
	</view>

</template>

<script>
	import rankitem from '@/components/common/rankitem.vue'
	export default {
		data() {
			return {
				dataList: []
			}
		},
		methods: {

		},
		onLoad() {
			this.$request({
				url: '/user/rank',
				methods: 'GET',
			}).then(res => {
				console.log(res);
				this.dataList = res;
			}).catch(err => {
				console.log(err);
			})
		},
		components: {
			rankitem
		}
	}
</script>

<style>
	.container {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
	}

	.temp1 {
		display: flex;
		width: 100%;
		height: 100rpx;
	}
	.ranking-text{
		display: flex;
		width: 100%;
		height: 100rpx;
		justify-content: center;
		align-items: center;
	}
	.inner-icon{
		display: flex;
		width: 100rpx;
		height: 100rpx;
	}
	.four-text{
		display: flex;
		width: 100%;
		height: 80rpx;
		justify-content: center;
		align-items: center;
		gap:80rpx;
	}
	.items{
		display: flex;
		flex-wrap: wrap;
		width: 100%;
		justify-content: center;
		align-items: center;
	}
</style>