import request from '~/utils/request'

const regionApi = "/front/cmn/region";

export default {
    regionList(parentCode) {
        return request({
            url: `${regionApi}/getRegionList/${parentCode}`,
            method: 'get'
        })
    }
}