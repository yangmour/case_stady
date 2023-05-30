
import request from "@/utils/request"
import { status } from "nprogress"
const API = "/admin/hosp/hospitalSet"

export default {
    getPageList(pageNum, pageSize, searchObj) {
        return request({
            url: `${API}/page/${pageNum}/${pageSize}`,
            method: "post",
            data: searchObj
        })
    },
    deleteById(id){
        return request({
            url: `${API}/delete/${id}`,
            method: "delete"
        })
    },
    batchDelete(ids){
        return request({
            url: `${API}/batchDelete`,
            method: "delete",
            data: ids
        })
    },
    updateStatus(id,status){
        return request({
            url: `${API}/updateStatus/${id}/${status}`,
            method: "put",
        })
    }
}