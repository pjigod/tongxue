<template>
	<view class="container">
		<view class="search-content">
			<view class="temp1" @click="navTo('/pages/search/search')">
				<img src="../../../static/image/search.png" style="height: 100%;width: 100%;"></img>
			</view>
			<view class="searchtext">
				<text style="font-size: 50rpx;">同学</text>
			</view>
			<view class="seaech-icon">

			</view>
		</view>
		<view class="topbar">
			<scroll-view scroll-x="true" class="scroll-content">
				<view class="scroll-item" v-for='(item,index) in topBar' :key="index" @tap="changeIndex(index)">
					<text :class='topBarindex===index?"scroll-text":"f-color"'>{{item.name}}</text>
				</view>
			</scroll-view>
			<swiper @change="onchangebar" :current="topBarindex" :style="'height:'+clentheight+'px;'">
				<swiper-item>
					<view class="home-data">
						<post-list :dataList='dataList'></post-list>

					</view>

				</swiper-item>
				<!-- <swiper-item v-for='(item,index) in topBar'
				:key="index">
					<view>
						<postList></postList>
					</view>
				</swiper-item> -->
				<swiper-item>
					<view>
						11111
					</view>
				</swiper-item>
			</swiper>
		</view>
		<view class="publishimage" @click="navTo('/pages/postPublish/postPublish')">
			<img src="../../../static/image/postpublish.png" style="width: 80rpx;
		height: 80rpx;"></img>
		</view>
	</view>
</template>

<script>
	import postList from '@/components/common/postList.vue'
	import {
		mapState
	} from 'vuex'
	export default {
		data() {
			return {
				dataList:[],
				clentheight: 0,
				topBarindex: 0,
				topBar: [{
						name: '关注'
					},
					{
						name: '推荐'
					},
					{
						name: '热门'
					}
				]
			}
		},
		computed: {
			...mapState({
				loginStatus: state => state.user.loginStatus,
				accountId: state => state.user.accountId
			})
		},
		components: {
			postList
		},
		onLoad() {
			this.$request({
				url:'/post/getall',
				methods:'GET',
				
			}).then(res=>{
				console.log(res);
				this.dataList=res;
			}).catch(err=>{
				console.log(err);
			})
		},
		methods: {
			alarm() {
				if (!this.loginStatus) {
					uni.showToast({
						title: '请先进行登录',
						icon: 'error',
						duration: 1500
					})
				}
			},

			navTo(url) {
				console.log('跳转路径', url);
				if (!this.loginStatus) {
					url = '/pages/login/login';
				}
				uni.navigateTo({
					url
				});

			},
			changeIndex(index) {
				if (this.topBarindex === index) {
					return;
				} else
					this.topBarindex = index;
			},
			onchangebar(e) {
				this.changeIndex(e.detail.current)
			}
		},
		onReady() {
			let view = uni.createSelectorQuery().select('.home-data');
			view.boundingClientRect(data => {
				this.clentheight = data.height;
				console.log(data.height);
			}).exec();
		}
	}
</script>

<style>
	.container {
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		height: 100%;
	}

	.publishimage {
		width: 80rpx;
		height: 80rpx;
		position: fixed;
		bottom: 100rpx;
		right: 30rpx;
	}

	.search-content {
		height: 100rpx;
		width: 100%;
		display: flex;
		align-items: center;
	}

	.temp1 {
		display: flex;
		height: 60rpx;
		width: 8%;
		margin-left: 15rpx;
	}

	.searchtext {
		display: flex;
		width: 84%;
		height: 100%;
		justify-content: center;
		align-items: center;

	}

	.seaech-icon {
		display: flex;
		height: 60rpx;
		width: 8%;
		margin-right: 15rpx;
	}

	.scroll-content {
		display: flex;
		width: 100%;
		height: 80rpx;
		white-space: nowrap;
		justify-content: center;
		align-items: center;
	}

	.scroll-item {
		display: flex;
		display: inline-block;
		padding: 10rpx 30rpx;
		font-size: 36rpx;
		margin-left: 90rpx;
	}

	.scroll-text {
		padding: 10rpx 0;
		color: #49bdfb;
		font-size: 40rpx;
		border-bottom: 6rpx solid #49bdfb;
	}

	.f-color {
		padding: 10rpx 0;
		color: #636263;
	}

	.home-data {
		width: 100%;
	}
</style>