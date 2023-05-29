import defaultSettings from '@/settings'

const title = defaultSettings.title || '尚医通'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
