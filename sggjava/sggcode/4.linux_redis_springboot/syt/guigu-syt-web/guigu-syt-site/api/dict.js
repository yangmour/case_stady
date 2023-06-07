import request from '~/utils/request'

const dictApi = "/front/cmn/dict";

export default {

    dictList(dictTypeId) {
        return request({
            url: `${dictApi}/getDictList/${dictTypeId}`,
            method: 'get'
        })
    }
}