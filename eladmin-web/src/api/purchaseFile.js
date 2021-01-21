import request from '@/utils/request'


export const getDateNums = (date) => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('') + [hour, minute, second].map(formatNumber).join('')
}
const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}
export function add(data) {
  data.providerId = '01' + getDateNums(new Date())
  data.checkTag = 0
  return request({
    url: 'api/purchaseFile',
    method: 'post',
    data
  })
}

export function del(ids) {
  return request({
    url: 'api/purchaseFile/',
    method: 'delete',
    data: ids
  })
}

export function edit(data) {
  return request({
    url: 'api/purchaseFile',
    method: 'put',
    data
  })
}

export default { add, edit, del }
