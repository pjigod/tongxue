<template>
	  <!-- <view>
	    <text v-for="(item, index) in dataList" :key="index">{{ item.totaltime}}</text>
	  </view> -->
</template>

<script>
	import postList from '@/components/common/postList.vue'
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
			url:'/user/rank',
			methods:'GET',
		}).then(res=>{
			console.log(res);
			this.dataList=res;
		}).catch(err=>{
			console.log(err);
		})
		},
		components: {
			postList
		}
	}
</script>

<style>

</style>