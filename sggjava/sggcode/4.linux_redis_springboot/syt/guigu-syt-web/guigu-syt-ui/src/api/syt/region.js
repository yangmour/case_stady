import request from "@/utils/request"

const API = "/admin/cmn/region"
export default {
    getRegionList(parentCode) {
        return request({
            url: `${API}/findRegionListByParentCode/${parentCode}`,
            method: "get"
        })
    }

}