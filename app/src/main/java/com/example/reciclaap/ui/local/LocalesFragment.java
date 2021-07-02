package com.example.reciclaap.ui.local;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.reciclaap.R;
import com.example.reciclaap.modelo.Local;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LocalesFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private LocalesViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ViewModelProviders.of(this).get(LocalesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_locales, container, false);

        inicializar(root);
        return root;
    }

    public  void inicializar(View v)
    {
        viewPager= v.findViewById(R.id.viewPage);
        appBarLayout= v.findViewById(R.id.appbar);
        tabLayout = new TabLayout(getContext());
        appBarLayout.addView(tabLayout);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(LocalesViewModel.class);
        vm.getLocalesMutable().observe(getViewLifecycleOwner(), new Observer<ArrayList<Local>>() {
            @Override
            public void onChanged(ArrayList<Local> locales) {

                ViewPageAdapter adapter = new ViewPageAdapter(getParentFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
                int numero=0;
                for(Local local : locales)
                {
                    numero++;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("local",local);
                    LocalFragment fragment= new LocalFragment();
                    fragment.setArguments(bundle);
                    adapter.addFragment(fragment,"local "+numero);
                }

                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        vm.cargarLocales();

    }

    public class ViewPageAdapter extends FragmentPagerAdapter
    {
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulos= new ArrayList<>();
        private int numero;

        public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            return fragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulos.get(position);
        }

        public  void  addFragment(Fragment fragment, String titulo)
        {
            fragmentList.add(fragment);
            titulos.add(titulo);
        }
    }

}