package vef.ter.hw1_7.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!
    protected abstract fun inflaterViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ): VB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = inflaterViewBinding(inflater, container)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initRV()
        initLiveData()
    }

    open fun initView() {}
    open fun initRV() {}
    open fun initLiveData() {}
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}