<template>
	<view>
		{{pid}}
	</view>
</template>

<script>
	export default {
		data() {
			return {
				pid: '',
			}
		},
		methods: {

		},
		onLoad(options) {
			this.pid = options.pid
		},
	}
	
</script>

<style>

</style>