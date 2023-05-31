import request from "@/utils/request"

const API = "/cmn/dict"
export default {

    getList() {
        return request({
            url: `${API}/findAll`,
            method: "get"
        })
    }

}