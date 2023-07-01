
export default {
	state: {
		loginStatus: false,		
		accountId: '',


	},
	getters: {


	},
	mutations: {

		setAccountId(state, AccountId) {
			state.accountId = AccountId;
		},
		hasLogin(state, userInfo) {
			state.loginStatus = true;
		},
		hasLogout(state) {
			state.loginStatus = false;
			state.accountId = null;
			uni.clearStorageSync();
		}

	},
	actions: {
		
	}
}