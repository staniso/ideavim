package com.maddyhome.idea.vim.newapi

import com.intellij.codeInsight.template.impl.TemplateManagerImpl
import com.intellij.codeInsight.template.impl.TemplateState
import com.intellij.openapi.components.Service
import com.maddyhome.idea.vim.api.VimEditor
import com.maddyhome.idea.vim.api.VimTemplateManager
import com.maddyhome.idea.vim.api.VimTemplateState

@Service
class IjTemplateManager : VimTemplateManager {
  override fun getTemplateState(editor: VimEditor): VimTemplateState? {
    return TemplateManagerImpl.getTemplateState(editor.ij)?.let { IjTemplateState(it) }
  }
}

class IjTemplateState(val templateState: TemplateState) : VimTemplateState
