
import request from "@/utils/request"
const API = "/admin/hosp/hospitalSet"

export default {
    getPageList(pageNum, pageSize, searchObj) {
        return request({
            url: `${API}/page/${pageNum}/${pageSize}`,
            method: "post",
            data: searchObj
        })
    }
}