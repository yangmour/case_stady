
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
    deleteById(id) {
        return request({
            url: `${API}/delete/${id}`,
            method: "delete"
        })
    },
    batchDelete(ids) {
        return request({
            url: `${API}/batchDelete`,
            method: "delete",
            data: ids
        })
    },
    updateStatus(id, status) {
        return request({
            url: `${API}/updateStatus/${id}/${status}`,
            method: "put",
        })
    },
    save(hospset) {
        return request({
            url: `${API}/saveHospSet`,
            method: "post",
            data: hospset
        })
    },
    update(hospset) {
        return request({
            url: `${API}/update`,
            method: "put",
            data: hospset
        })
    },
    edit(id) {
        return request({
            url: `${API}/edit/${id}}`,
            method: "get"
        })
    }
}